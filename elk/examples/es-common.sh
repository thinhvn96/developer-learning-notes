# Sourced by the Elasticsearch example scripts: starts a throwaway single-node cluster and defines helpers.
NAME=es-lesson-$$
docker run -d --rm --name "$NAME" -p 127.0.0.1::9200 \
  -e discovery.type=single-node -e xpack.security.enabled=false -e ES_JAVA_OPTS="-Xms512m -Xmx512m" \
  docker.elastic.co/elasticsearch/elasticsearch:9.0.0 >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
PORT=$(docker port "$NAME" 9200/tcp | head -1 | sed 's/.*://')
ES=http://127.0.0.1:$PORT
until curl -sf "$ES/_cluster/health" >/dev/null 2>&1; do sleep 3; done
j() { curl -s -H 'content-type: application/json' "$@"; echo; }
