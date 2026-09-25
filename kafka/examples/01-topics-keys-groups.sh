#!/usr/bin/env bash
# Usage: ./01-topics-keys-groups.sh
# Starts a throwaway single-node Kafka (KRaft) container, then shows partitions, keys and consumer groups.
set -euo pipefail
NAME=kafka-lesson-$$
docker run -d --rm --name "$NAME" apache/kafka:latest >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
K=/opt/kafka/bin
until docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server localhost:9092 --list >/dev/null 2>&1; do sleep 1; done

echo "=== create topic 'orders' with 3 partitions"
docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic orders --partitions 3 --replication-factor 1
docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic orders | sed 's/\t/ /g'

echo "=== produce keyed messages (key:value)"
printf 'u1:a\nu2:b\nu1:c\nu3:d\nu1:e\nu2:f\n' | docker exec -i "$NAME" $K/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 --topic orders --reader-property parse.key=true --reader-property key.separator=:

echo "=== consume everything, showing key and partition"
docker exec "$NAME" $K/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic orders \
  --from-beginning --timeout-ms 5000 --formatter-property print.key=true --formatter-property print.partition=true 2>/dev/null | sort

echo "=== consume once in group g1, then describe the group (offsets and lag)"
docker exec "$NAME" $K/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic orders \
  --group g1 --from-beginning --max-messages 6 --timeout-ms 8000 >/dev/null 2>&1
docker exec "$NAME" $K/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group g1
