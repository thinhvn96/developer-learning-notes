#!/usr/bin/env bash
# Usage: ./01-routing-ack-dlx.sh
# Throwaway RabbitMQ: exchange types, manual ack/requeue, and dead-lettering, driven through the HTTP management API.
set -euo pipefail
NAME=rabbit-lesson-$$
docker run -d --rm --name "$NAME" -p 127.0.0.1::15672 rabbitmq:4-management >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
# Poll the log, not the CLI: calling the CLI before the node is up can create a mismatched Erlang cookie.
until docker logs "$NAME" 2>&1 | grep -q "Time to start RabbitMQ"; do sleep 2; done
PORT=$(docker port "$NAME" 15672/tcp | head -1 | sed 's/.*://')
B=http://127.0.0.1:$PORT/api
until curl -sf -u guest:guest "$B/overview" >/dev/null 2>&1; do sleep 2; done
api() { curl -s -u guest:guest -H 'content-type: application/json' "$@"; }
put()  { api -X PUT  "$B/$1" -d "$2" >/dev/null; }
post() { api -X POST "$B/$1" -d "$2"; }

echo "=== 1. direct, fanout and topic exchanges"
put exchanges/%2F/ex.direct '{"type":"direct"}'
put exchanges/%2F/ex.fanout '{"type":"fanout"}'
put exchanges/%2F/ex.topic  '{"type":"topic"}'
for q in q.errors q.all q.eu; do put queues/%2F/$q '{"durable":true}'; done
api -X POST $B/bindings/%2F/e/ex.direct/q/q.errors -d '{"routing_key":"error"}' >/dev/null
api -X POST $B/bindings/%2F/e/ex.fanout/q/q.all    -d '{}' >/dev/null
api -X POST $B/bindings/%2F/e/ex.fanout/q/q.eu     -d '{}' >/dev/null
api -X POST $B/bindings/%2F/e/ex.topic/q/q.eu      -d '{"routing_key":"orders.eu.*"}' >/dev/null
pub() { post "exchanges/%2F/$1/publish" "{\"properties\":{},\"routing_key\":\"$2\",\"payload\":\"$3\",\"payload_encoding\":\"string\"}"; echo " <- $1 '$2'"; }
pub ex.direct error    boom
pub ex.direct info     ignored
pub ex.fanout anything hello-all
pub ex.topic  orders.eu.created eu-order
pub ex.topic  orders.us.created us-order
sleep 1
depth() { docker exec "$NAME" rabbitmqctl -q list_queues name messages | awk -v q="$1" '$1==q {print $2}'; }
for q in q.errors q.all q.eu; do echo "queue $q depth: $(depth $q)"; done

echo "=== 2. manual ack: a fetched-but-unacked message is redelivered"
put queues/%2F/q.work '{"durable":true}'
post exchanges/%2F/amq.default/publish '{"properties":{},"routing_key":"q.work","payload":"job-1","payload_encoding":"string"}' >/dev/null
echo "get with ack_requeue_true (like a consumer that died before acking):"
post queues/%2F/q.work/get '{"count":1,"ackmode":"ack_requeue_true","encoding":"auto"}' | sed -E 's/.*"redelivered":(true|false).*"payload":"([^"]*)".*/  redelivered=\1 payload=\2/'; echo
echo "get again:"
post queues/%2F/q.work/get '{"count":1,"ackmode":"ack_requeue_false","encoding":"auto"}' | sed -E 's/.*"redelivered":(true|false).*"payload":"([^"]*)".*/  redelivered=\1 payload=\2/'; echo

echo "=== 3. dead-lettering: reject without requeue"
put exchanges/%2F/ex.dlx '{"type":"fanout"}'
put queues/%2F/q.dead '{"durable":true}'
api -X POST $B/bindings/%2F/e/ex.dlx/q/q.dead -d '{}' >/dev/null
put queues/%2F/q.main '{"durable":true,"arguments":{"x-dead-letter-exchange":"ex.dlx"}}'
post exchanges/%2F/amq.default/publish '{"properties":{},"routing_key":"q.main","payload":"poison","payload_encoding":"string"}' >/dev/null
post queues/%2F/q.main/get '{"count":1,"ackmode":"reject_requeue_false","encoding":"auto"}' >/dev/null
sleep 1
echo "q.main depth: $(depth q.main)   q.dead depth: $(depth q.dead)"
