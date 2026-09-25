#!/usr/bin/env bash
# Usage: ./03-connect-file.sh   Kafka Connect (standalone) with the bundled FileStream source and sink connectors,
# plus the Connect REST API on port 8083. FileStream connectors are for demos, not production.
set -euo pipefail
NAME=kafka-connect-$$
docker run -d --rm --name "$NAME" apache/kafka:latest >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
K=/opt/kafka/bin; B=localhost:9092
until docker exec "$NAME" $K/kafka-topics.sh --bootstrap-server $B --list >/dev/null 2>&1; do sleep 1; done
docker exec "$NAME" sh -c 'printf "line one\nline two\nline three\n" > /tmp/in.txt'
docker exec "$NAME" sh -c "cat > /tmp/source.properties <<'P'
name=demo-file-source
connector.class=org.apache.kafka.connect.file.FileStreamSourceConnector
tasks.max=1
file=/tmp/in.txt
topic=connect-demo
P
cat > /tmp/sink.properties <<'P'
name=demo-file-sink
connector.class=org.apache.kafka.connect.file.FileStreamSinkConnector
tasks.max=1
file=/tmp/out.txt
topics=connect-demo
P
cat > /tmp/worker.properties <<'P'
bootstrap.servers=localhost:9092
key.converter=org.apache.kafka.connect.json.JsonConverter
value.converter=org.apache.kafka.connect.json.JsonConverter
key.converter.schemas.enable=false
value.converter.schemas.enable=false
offset.storage.file.filename=/tmp/connect.offsets
plugin.path=/opt/kafka/libs
P"
docker exec -d "$NAME" sh -c "$K/connect-standalone.sh /tmp/worker.properties /tmp/source.properties /tmp/sink.properties > /tmp/connect.log 2>&1"
for i in $(seq 1 60); do docker exec "$NAME" sh -c 'test -s /tmp/out.txt' 2>/dev/null && break; sleep 2; done
echo "=== the source connector read /tmp/in.txt into topic connect-demo; the sink wrote /tmp/out.txt:"
docker exec "$NAME" cat /tmp/out.txt
echo "=== connectors via the REST API:"
docker exec "$NAME" sh -c 'wget -qO- http://localhost:8083/connectors'; echo
echo "=== append a line to the source file; it flows through Kafka to the sink:"
docker exec "$NAME" sh -c 'echo "line four" >> /tmp/in.txt'; sleep 8
docker exec "$NAME" tail -1 /tmp/out.txt
echo "=== the topic itself:"
docker exec "$NAME" $K/kafka-console-consumer.sh --bootstrap-server $B --topic connect-demo --from-beginning --timeout-ms 4000 2>/dev/null | tail -2
