#!/usr/bin/env bash
# Usage: ./03-analysis-bulk-aggs.sh   Text analysis, the bulk API, and aggregations.
set -euo pipefail
source "$(dirname "$0")/es-common.sh"

echo "=== 1. the standard analyzer turns text into tokens"
j -X POST "$ES/_analyze" -d '{"analyzer":"standard","text":"Connection Timeout to payment-service!"}' | python3 -c "import sys,json; print([t['token'] for t in json.load(sys.stdin)['tokens']])"
echo "=== keyword analyzer keeps the whole value as one token"
j -X POST "$ES/_analyze" -d '{"analyzer":"keyword","text":"Connection Timeout"}' | python3 -c "import sys,json; print([t['token'] for t in json.load(sys.stdin)['tokens']])"

echo "=== 2. bulk API: NDJSON, one request, per-item results"
curl -s -H 'content-type: application/x-ndjson' -X POST "$ES/_bulk?refresh=true" --data-binary $'{"index":{"_index":"logs","_id":"1"}}\n{"level":"ERROR","service":"orders","ms":120}\n{"index":{"_index":"logs","_id":"2"}}\n{"level":"INFO","service":"orders","ms":30}\n{"index":{"_index":"logs","_id":"3"}}\n{"level":"ERROR","service":"payments","ms":900}\n{"index":{"_index":"logs","_id":"4"}}\n{"level":"INFO","service":"payments","ms":45}\n{"create":{"_index":"logs","_id":"1"}}\n{"level":"DUP"}\n' \
 | python3 -c "
import sys,json
r=json.load(sys.stdin)
print('errors flag:', r['errors'])
for i in r['items']:
    k=list(i)[0]; v=i[k]; print(' ', k, v['_id'], v['status'], v.get('error',{}).get('type',''))"

echo "=== 3. aggregations: bucket (terms) + metric (avg, max)"
j -X POST "$ES/logs/_search?size=0" -d '{"aggs":{"by_service":{"terms":{"field":"service.keyword"},"aggs":{"avg_ms":{"avg":{"field":"ms"}},"max_ms":{"max":{"field":"ms"}}}}}}' \
 | python3 -c "
import sys,json
for b in json.load(sys.stdin)['aggregations']['by_service']['buckets']:
    print(' ', b['key'], 'docs=',b['doc_count'], 'avg_ms=',b['avg_ms']['value'], 'max_ms=',b['max_ms']['value'])"
echo "=== terms on the analyzed text field is refused by default:"
j -X POST "$ES/logs/_search?size=0" -d '{"aggs":{"x":{"terms":{"field":"service"}}}}' | python3 -c "import sys,json; r=json.load(sys.stdin); print(' ', r.get('error',{}).get('root_cause',[{}])[0].get('reason','(no error)')[:110])"
