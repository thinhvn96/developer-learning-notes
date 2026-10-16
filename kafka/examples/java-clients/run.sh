#!/usr/bin/env bash
# Usage: ./run.sh   (needs JDK 17+ and Docker; port 9092 must be free)
# Copies kafka-clients from the image, starts Kafka with port 9092 published, then runs
# the producer and the consumer with both group protocols (lessons 0011 and 0015).
cd "$(dirname "$0")"
PUBLISH=1 source ../kafka-common.sh
mkdir -p lib
if [[ ! -f lib/.done ]]; then
  for j in kafka-clients slf4j-api lz4-java snappy-java zstd-jni; do
    f=$(docker exec "$NAME" sh -c "ls /opt/kafka/libs/$j-*.jar"); docker cp -q "$NAME:$f" lib/
  done; touch lib/.done
fi
kx kafka-topics.sh $BS --create --topic orders --partitions 3 --replication-factor 1 >/dev/null
CP="lib/*"
echo "=== producer";                 java -cp "$CP" OrderProducer.java 2>/dev/null
echo "=== consumer, classic protocol"; java -cp "$CP" OrderConsumer.java classic 2>/dev/null
echo "=== consumer, KIP-848 protocol"; java -cp "$CP" OrderConsumer.java consumer 2>/dev/null
echo "=== groups"
kx kafka-consumer-groups.sh $BS --describe --group billing-consumer --state 2>/dev/null | sed 's/  */ /g'
kx kafka-consumer-groups.sh $BS --describe --group billing-classic --state 2>/dev/null | sed 's/  */ /g'
