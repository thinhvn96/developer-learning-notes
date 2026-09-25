#!/usr/bin/env bash
# Usage: ./02-run-and-lifecycle.sh   Uses the small nginx:alpine image.
set -euo pipefail
NAME=lesson-web-$$
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
echo "=== -e sets an environment variable; --rm removes the container on exit"
docker run --rm -e GREETING=hello alpine sh -c 'echo "GREETING=$GREETING"'
echo "=== -d runs in the background, --name names it, -p publishes host:container"
docker run -d --name "$NAME" -p 127.0.0.1::80 nginx:alpine >/dev/null
PORT=$(docker port "$NAME" 80/tcp | head -1 | sed 's/.*://')
until curl -sf "http://127.0.0.1:$PORT" >/dev/null; do sleep 1; done
echo "GET / -> HTTP $(curl -s -o /dev/null -w '%{http_code}' http://127.0.0.1:$PORT)"
echo "=== lifecycle"
docker ps --filter "name=$NAME" --format 'running:  {{.Names}} {{.Status}}'
docker stop "$NAME" >/dev/null
docker ps -a --filter "name=$NAME" --format 'stopped:  {{.Names}} {{.Status}}'
docker rm "$NAME" >/dev/null
docker ps -a --filter "name=$NAME" --format '{{.Names}}' | wc -l | sed 's/^/after rm, containers named that: /'
