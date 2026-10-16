#!/usr/bin/env bash
# Usage: ./06-batching-and-compression.sh
# Runs kafka-producer-perf-test with different linger.ms / compression.type and prints
# throughput plus the bytes stored on disk (lesson 0014). Numbers vary by machine.
source "$(dirname "$0")/kafka-common.sh"
# 500k records of compressible JSON-ish text, one payload file reused by every run
ksh 'for i in $(seq 1 2000); do echo "{\"orderId\":$i,\"status\":\"CREATED\",\"customer\":\"customer-$((i%50))\",\"note\":\"standard delivery\"}"; done > /tmp/payload.txt'
run() {  # $1 topic, rest = producer props
  local t=$1; shift
  kx kafka-topics.sh $BS --create --topic "$t" --partitions 1 --replication-factor 1 >/dev/null
  local out
  out=$(kx kafka-producer-perf-test.sh --topic "$t" --num-records 500000 --throughput -1 \
        --payload-file /tmp/payload.txt --command-property bootstrap.servers=localhost:9092 acks=all "$@" 2>/dev/null | tail -1)
  local bytes
  bytes=$(ksh "du -sk /tmp/kraft-combined-logs/$t-0 | cut -f1")
  printf '%-34s %s | on disk: %s KB\n' "$*" "$(echo "$out" | grep -oE '[0-9.]+ records/sec \([0-9.]+ MB/sec\)')" "$bytes"
}
run t1 linger.ms=0 batch.size=16384 compression.type=none
run t2 linger.ms=5 batch.size=16384 compression.type=none
run t3 linger.ms=20 batch.size=131072 compression.type=none
run t4 linger.ms=20 batch.size=131072 compression.type=lz4
run t5 linger.ms=20 batch.size=131072 compression.type=zstd
