#!/usr/bin/env bash
# Usage: ./02-ttl-and-streams.sh   Message TTL with dead-lettering, and a stream queue.
set -euo pipefail
NAME=rabbit-ttl-$$
docker run -d --rm --name "$NAME" -p 127.0.0.1::15672 rabbitmq:4-management >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
until docker logs "$NAME" 2>&1 | grep -q "Time to start RabbitMQ"; do sleep 2; done
PORT=$(docker port "$NAME" 15672/tcp | head -1 | sed 's/.*://'); B=http://127.0.0.1:$PORT/api
until curl -sf -u guest:guest "$B/overview" >/dev/null 2>&1; do sleep 2; done
api() { curl -s -u guest:guest -H 'content-type: application/json' "$@"; }
put() { api -X PUT "$B/$1" -d "$2" >/dev/null; }
pub() { api -X POST "$B/exchanges/%2F/amq.default/publish" -d "{\"properties\":{$3},\"routing_key\":\"$1\",\"payload\":\"$2\",\"payload_encoding\":\"string\"}" >/dev/null; }
depth() { docker exec "$NAME" rabbitmqctl -q list_queues name messages | awk -v q="$1" '$1==q {print $2}'; }

echo "=== per-queue TTL (x-message-ttl=2000) with a dead letter exchange"
put exchanges/%2F/ex.expired '{"type":"fanout"}'
put queues/%2F/q.expired '{"durable":true}'
api -X POST "$B/bindings/%2F/e/ex.expired/q/q.expired" -d '{}' >/dev/null
put queues/%2F/q.ttl '{"durable":true,"arguments":{"x-message-ttl":2000,"x-dead-letter-exchange":"ex.expired"}}'
pub q.ttl m1 ''; pub q.ttl m2 ''
echo "right after publish : q.ttl=$(depth q.ttl) q.expired=$(depth q.expired)"
sleep 4
echo "after 4 s           : q.ttl=$(depth q.ttl) q.expired=$(depth q.expired)"

echo "=== per-message TTL (expiration=1000 ms) on a queue without TTL"
put queues/%2F/q.plain '{"durable":true}'
pub q.plain short '"expiration":"1000"'
pub q.plain long ''
sleep 3
echo "queue depth after 3 s: $(depth q.plain)   (the message with no TTL is still there)"

echo "=== stream: consuming does not remove messages"
put queues/%2F/q.stream '{"durable":true,"arguments":{"x-queue-type":"stream"}}'
pub q.stream s1 ''; pub q.stream s2 ''; pub q.stream s3 ''
sleep 1
docker exec "$NAME" rabbitmqctl -q list_queues name type messages | awk '$1=="q.stream"{print "stream queue: type="$2" messages="$3}'
echo "get (destructive on a classic queue) against the stream:"
api -X POST "$B/queues/%2F/q.stream/get" -d '{"count":1,"ackmode":"ack_requeue_false","encoding":"auto"}' | head -c 200; echo
