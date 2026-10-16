#!/usr/bin/env bash
# Usage: ./05-add-partitions.sh
# Shows that adding partitions changes which partition a key maps to (lesson 0012).
source "$(dirname "$0")/kafka-common.sh"
kx kafka-topics.sh $BS --create --topic users --partitions 3 --replication-factor 1 >/dev/null
where() {  # print "key -> partition" for every record whose value is $1
  kx kafka-console-consumer.sh $BS --topic users --from-beginning --timeout-ms 5000 \
    --formatter-property print.key=true --formatter-property print.partition=true 2>/dev/null \
    | awk -v tag="$1" '$3==tag {print "  " $2 " -> " $1}' | sort -k1
}
for k in u1 u2 u3 u4 u5 u6; do echo "$k:before"; done | kx kafka-console-producer.sh $BS --topic users \
  --reader-property parse.key=true --reader-property key.separator=:
echo "=== 3 partitions"; where before
kx kafka-topics.sh $BS --alter --topic users --partitions 6
for k in u1 u2 u3 u4 u5 u6; do echo "$k:after"; done | kx kafka-console-producer.sh $BS --topic users \
  --reader-property parse.key=true --reader-property key.separator=:
echo "=== 6 partitions (same keys)"; where after
echo "=== try to shrink back to 3"
kx kafka-topics.sh $BS --alter --topic users --partitions 3 2>&1 | grep -m1 -i -E "error|exception" || true
