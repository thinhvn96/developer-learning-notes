#!/usr/bin/env bash
# Usage: ./04-streams-wordcount.sh   Runs the WordCount demo bundled with Kafka (kafka-streams-examples jar).
set -euo pipefail
NAME=kafka-streams-$$
docker run -d --rm --name "$NAME" apache/kafka:latest >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
K=/opt/kafka/bin; B=localhost:9092
until docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B --list >/dev/null 2>&1; do sleep 1; done
docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B --create --topic streams-plaintext-input --partitions 1 --replication-factor 1 >/dev/null
docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B --create --topic streams-wordcount-output --partitions 1 --replication-factor 1 >/dev/null
# The Alpine-based image lacks libstdc++, which the RocksDB state store needs (found by running it: UnsatisfiedLinkError).
docker exec -u root "$NAME" apk add --no-cache libstdc++ >/dev/null
docker exec -d "$NAME" sh -c 'java -cp "/opt/kafka/libs/*" org.apache.kafka.streams.examples.wordcount.WordCountDemo > /tmp/streams.log 2>&1'
sleep 10
printf 'all streams lead to kafka\nhello kafka streams\n' | docker exec -i "$NAME" $K/kafka-console-producer.sh --bootstrap-server $B --topic streams-plaintext-input 2>/dev/null
sleep 10
echo "=== word counts (a KTable: the latest count per word; the output topic is its changelog)"
docker exec "$NAME" $K/kafka-console-consumer.sh --bootstrap-server $B --topic streams-wordcount-output --from-beginning --timeout-ms 6000 \
  --formatter-property print.key=true --value-deserializer org.apache.kafka.common.serialization.LongDeserializer 2>/dev/null
