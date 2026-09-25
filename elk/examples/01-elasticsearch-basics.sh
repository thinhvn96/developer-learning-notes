#!/usr/bin/env bash
# Usage: ./01-elasticsearch-basics.sh
# Throwaway single-node Elasticsearch 9.0.0 (security disabled: demo only, never in production).
set -euo pipefail
NAME=es-lesson-$$
docker run -d --rm --name "$NAME" -p 127.0.0.1::9200 \
  -e discovery.type=single-node -e xpack.security.enabled=false -e ES_JAVA_OPTS="-Xms512m -Xmx512m" \
  docker.elastic.co/elasticsearch/elasticsearch:9.0.0 >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
PORT=$(docker port "$NAME" 9200/tcp | head -1 | sed 's/.*://')
ES=http://127.0.0.1:$PORT
until curl -sf "$ES/_cluster/health" >/dev/null 2>&1; do sleep 3; done
j() { curl -s -H 'content-type: application/json' "$@"; echo; }

echo "=== 1. explicit mapping: message is analyzed text, level is an exact-value keyword"
j -X PUT "$ES/logs" -d '{"mappings":{"properties":{"message":{"type":"text"},"level":{"type":"keyword"},"service":{"type":"keyword"}}}}'
j -X POST "$ES/logs/_doc?refresh=false" -d '{"message":"Connection Timeout to payment-service","level":"ERROR","service":"orders"}'
j -X POST "$ES/logs/_doc?refresh=false" -d '{"message":"Order created","level":"INFO","service":"orders"}'

echo "=== 2. near real-time: searchable only after a refresh"
echo -n "hits before refresh: "; curl -s "$ES/logs/_count" | sed -E 's/.*"count":([0-9]+).*/\1/'; echo
curl -s -X POST "$ES/logs/_refresh" >/dev/null
echo -n "hits after  refresh: "; curl -s "$ES/logs/_count" | sed -E 's/.*"count":([0-9]+).*/\1/'; echo

count() { curl -s -H 'content-type: application/json' "$ES/logs/_search" -d "$1" | sed -E 's/.*"total":\{"value":([0-9]+).*/\1/'; echo; }
echo "=== 3. term vs match on a text field"
echo -n "term  'Timeout' (exact, case-sensitive token): "; count '{"query":{"term":{"message":"Timeout"}}}'
echo -n "term  'timeout' (matches the lowercased token): "; count '{"query":{"term":{"message":"timeout"}}}'
echo -n "match 'Timeout' (query is analyzed too):        "; count '{"query":{"match":{"message":"Timeout"}}}'

echo "=== 4. bool: filter on exact fields, must for relevance"
echo -n "ERROR logs mentioning payment: "; count '{"query":{"bool":{"filter":[{"term":{"level":"ERROR"}}],"must":[{"match":{"message":"payment"}}]}}}'

echo "=== 5. shards and replicas on a single node"
curl -s "$ES/_cat/shards/logs?h=index,shard,prirep,state"
curl -s "$ES/_cluster/health/logs" | sed -E 's/.*"status":"([a-z]+)".*/index health: \1/'
