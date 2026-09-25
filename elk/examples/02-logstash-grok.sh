#!/usr/bin/env bash
# Usage: ./02-logstash-grok.sh   Parses two log lines with grok; the second does not match and gets _grokparsefailure.
set -euo pipefail
cd "$(dirname "$0")"
printf '10.0.0.7 GET /orders/42 200 35\nthis is not an access log\n' | docker run --rm -i \
  -v "$PWD/logstash-grok.conf:/usr/share/logstash/pipeline/logstash.conf:ro" \
  -e LS_JAVA_OPTS="-Xms256m -Xmx256m" -e XPACK_MONITORING_ENABLED=false \
  docker.elastic.co/logstash/logstash:9.0.0 2>&1 | grep -vE '^(\[|Using|Sending|WARNING)' | sed -n '/{/,$p'
