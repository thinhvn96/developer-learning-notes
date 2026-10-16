#!/usr/bin/env bash
# Usage: ./08-share-group.sh
# Two share consumers read ONE partition together (lesson 0021). In a consumer group,
# one partition belongs to exactly one consumer, so the second one would sit idle.
source "$(dirname "$0")/kafka-common.sh"
kx kafka-topics.sh $BS --create --topic jobs --partitions 1 --replication-factor 1 >/dev/null
for c in A B; do   # start both share consumers first, in the same share group "workers"
  ( kx kafka-console-share-consumer.sh $BS --topic jobs --group workers --timeout-ms 20000 2>/dev/null \
      | sed "s/^/$c /" > /tmp/share-$c-$$.txt ) &
done
sleep 8
for i in $(seq 1 20); do echo "job-$i"; sleep 0.3; done | kx kafka-console-producer.sh $BS --topic jobs
wait
echo "=== records per consumer (same single partition)"
for c in A B; do echo "consumer $c: $(wc -l < /tmp/share-$c-$$.txt) records: $(cut -d' ' -f2 /tmp/share-$c-$$.txt | tr '\n' ' ')"; done
rm -f /tmp/share-*-$$.txt
echo "=== kafka-share-groups.sh --describe"
kx kafka-share-groups.sh $BS --describe --group workers 2>/dev/null | sed 's/  */ /g'
