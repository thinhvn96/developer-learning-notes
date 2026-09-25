#!/usr/bin/env bash
# Usage: ./03-cluster-quorum.sh   A 3-node RabbitMQ cluster in Docker, a quorum queue, and a node failure.
set -euo pipefail
NET=rabbit-cluster-$$; COOKIE=lessoncookie
cleanup() { for n in 1 2 3; do docker rm -f rmq$n-$$ >/dev/null 2>&1 || true; done; docker network rm "$NET" >/dev/null 2>&1 || true; }
trap cleanup EXIT
docker network create "$NET" >/dev/null
for n in 1 2 3; do
  docker run -d --name rmq$n-$$ --hostname rmq$n --network "$NET" -e RABBITMQ_ERLANG_COOKIE=$COOKIE \
    $( [ $n = 1 ] && echo "-p 127.0.0.1::15672" ) rabbitmq:4-management >/dev/null
done
for n in 1 2 3; do until docker logs rmq$n-$$ 2>&1 | grep -q "Time to start RabbitMQ"; do sleep 2; done; done
for n in 2 3; do
  docker exec rmq$n-$$ rabbitmqctl stop_app >/dev/null
  docker exec rmq$n-$$ rabbitmqctl join_cluster rabbit@rmq1 >/dev/null
  docker exec rmq$n-$$ rabbitmqctl start_app >/dev/null
done
echo "=== cluster members:"
docker exec rmq1-$$ rabbitmqctl -q cluster_status | grep -A4 'Running Nodes'
PORT=$(docker port rmq1-$$ 15672/tcp | head -1 | sed 's/.*://'); B=http://127.0.0.1:$PORT/api
until curl -sf -u guest:guest "$B/overview" >/dev/null 2>&1; do sleep 2; done
api() { curl -s -u guest:guest -H 'content-type: application/json' "$@"; }
echo "=== a classic queue lives on ONE node; a quorum queue is replicated on all three"
api -X PUT "$B/queues/%2F/q.classic" -d '{"durable":true,"node":"rabbit@rmq1"}' >/dev/null
api -X PUT "$B/queues/%2F/q.quorum" -d '{"durable":true,"arguments":{"x-queue-type":"quorum"}}' >/dev/null
for q in q.classic q.quorum; do
  for i in 1 2 3; do api -X POST "$B/exchanges/%2F/amq.default/publish" -d "{\"properties\":{\"delivery_mode\":2},\"routing_key\":\"$q\",\"payload\":\"m$i\",\"payload_encoding\":\"string\"}" >/dev/null; done
done
sleep 8
docker exec rmq1-$$ rabbitmqctl -q list_queues name type leader members messages 2>/dev/null | grep -E "q\.(classic|quorum)" || docker exec rmq1-$$ rabbitmqctl -q list_queues name type messages
echo "=== stop node rmq1, which is also the quorum queue leader; read from a surviving node"
docker stop rmq1-$$ >/dev/null
sleep 8
echo "quorum queue after node loss (asked via rmq2):"
docker exec rmq2-$$ rabbitmqctl -q list_queues name type messages 2>&1 | grep -E "q\.quorum|q\.classic|error|not" | head -3
