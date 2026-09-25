#!/usr/bin/env bash
# Usage: ./04-ingest-datastream-ilm.sh   Ingest pipeline (simulate + use), data stream with rollover, and an ILM policy.
set -euo pipefail
source "$(dirname "$0")/es-common.sh"

echo "=== 1. ingest pipeline: parse a line inside Elasticsearch (grok + lowercase + set)"
j -X PUT "$ES/_ingest/pipeline/access" -d '{"processors":[{"grok":{"field":"message","patterns":["%{IP:client} %{WORD:method} %{URIPATH:path} %{NUMBER:status:int}"]}},{"lowercase":{"field":"method"}},{"set":{"field":"pipeline","value":"access"}}]}' >/dev/null
echo "simulate:"
j -X POST "$ES/_ingest/pipeline/access/_simulate" -d '{"docs":[{"_source":{"message":"10.0.0.7 GET /orders/42 200"}},{"_source":{"message":"garbage"}}]}' \
 | python3 -c "
import sys,json
for d in json.load(sys.stdin)['docs']:
    print(' ', d['doc']['_source'] if 'doc' in d else d['error']['reason'][:80])"
echo "index through the pipeline, then search the parsed field:"
j -X PUT "$ES/weblogs/_doc/1?pipeline=access&refresh=true" -d '{"message":"10.0.0.7 GET /orders/42 200"}' >/dev/null
j "$ES/weblogs/_search?q=status:200" | python3 -c "import sys,json; print(' ', json.load(sys.stdin)['hits']['hits'][0]['_source'])"

echo "=== 2. data stream: append-only time series behind one name"
j -X PUT "$ES/_index_template/logs-app" -d '{"index_patterns":["logs-app*"],"data_stream":{},"priority":200,"template":{"settings":{"index.number_of_replicas":0}}}' >/dev/null
j -X POST "$ES/logs-app/_doc?refresh=true" -d '{"@timestamp":"2026-09-24T10:00:00Z","message":"first"}' | python3 -c "import sys,json; r=json.load(sys.stdin); print('  indexed into backing index:', r['_index'])"
echo "document without @timestamp is rejected:"
j -X POST "$ES/logs-app/_doc" -d '{"message":"no timestamp"}' | python3 -c "import sys,json; r=json.load(sys.stdin); print(' ', r.get('error',{}).get('reason','(accepted)')[:100])"
echo "rollover creates a new write index:"
j -X POST "$ES/logs-app/_rollover" | python3 -c "import sys,json; r=json.load(sys.stdin); print('  rolled over:', r['rolled_over'], ' old:', r['old_index'], ' new:', r['new_index'])"
curl -s "$ES/_data_stream/logs-app" | python3 -c "import sys,json; ds=json.load(sys.stdin)['data_streams'][0]; print('  backing indices:', [i['index_name'] for i in ds['indices']])"

echo "=== 3. ILM policy: rollover in hot, delete later"
j -X PUT "$ES/_ilm/policy/logs-policy" -d '{"policy":{"phases":{"hot":{"actions":{"rollover":{"max_age":"7d","max_primary_shard_size":"50gb"}}},"delete":{"min_age":"30d","actions":{"delete":{}}}}}}' >/dev/null
curl -s "$ES/_ilm/policy/logs-policy" | python3 -c "
import sys,json
p=json.load(sys.stdin)['logs-policy']['policy']['phases']
for name,ph in p.items(): print(' ', name, ph.get('min_age','0ms'), list(ph['actions']))"
