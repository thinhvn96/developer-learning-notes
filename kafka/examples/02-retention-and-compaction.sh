#!/usr/bin/env bash
# Usage: ./02-retention-and-compaction.sh   Topic configs, delete vs compact cleanup, and a tombstone.
set -euo pipefail
NAME=kafka-cfg-$$
docker run -d --rm --name "$NAME" apache/kafka:latest >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
K=/opt/kafka/bin; B=localhost:9092
until docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B --list >/dev/null 2>&1; do sleep 1; done
t() { docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B "$@"; }
cons() { docker exec "$NAME" $K/kafka-console-consumer.sh --bootstrap-server $B --topic "$1" --from-beginning --timeout-ms 4000 \
  --formatter-property print.key=true --formatter-property print.value=true 2>/dev/null; }
prod() { docker exec -i "$NAME" $K/kafka-console-producer.sh --bootstrap-server $B --topic "$1" \
  --reader-property parse.key=true --reader-property key.separator=: --reader-property null.marker=NULL 2>/dev/null; }

echo "=== default topic: cleanup.policy=delete, retention decided by time/size"
t --create --topic events --partitions 1 --replication-factor 1 >/dev/null
docker exec "$NAME" $K/kafka-configs.sh --bootstrap-server $B --describe --entity-type topics --entity-name events --all | grep -E "cleanup.policy|retention.ms|retention.bytes|segment.bytes " | sed 's/ sensitive.*//'

echo "=== compacted topic (aggressive settings so the demo finishes quickly)"
t --create --topic profile --partitions 1 --replication-factor 1 \
  --config cleanup.policy=compact --config segment.ms=1000 --config min.cleanable.dirty.ratio=0.01 \
  --config delete.retention.ms=100 --config min.compaction.lag.ms=0 >/dev/null
printf 'u1:v1\nu2:a\nu1:v2\nu1:v3\nu2:b\n' | prod profile
echo "before compaction:"; cons profile | sort | tr '\n' ' '; echo
# writing more records rolls the active segment so the cleaner can compact the older ones
for i in 1 2 3; do sleep 3; printf "filler$i:x\n" | prod profile; done
sleep 25
echo "after compaction (latest value per key kept, offsets never renumbered):"
cons profile | sort | tr '\n' ' '; echo
echo "=== tombstone: a key with a null value marks the key for deletion"
printf 'u2:NULL\n' | prod profile
for i in 1 2 3; do sleep 3; printf "more$i:x\n" | prod profile; done
sleep 25
cons profile | sort | tr '\n' ' '; echo
