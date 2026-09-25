#!/usr/bin/env bash
# Usage: ./run.sh 01-constraints.sql   (starts a throwaway postgres:18, runs the file, removes it)
set -euo pipefail
NAME=pg-lesson-$$
docker run -d --rm --name "$NAME" -e POSTGRES_PASSWORD=example postgres:18 >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
until docker exec "$NAME" pg_isready -U postgres -h 127.0.0.1 >/dev/null 2>&1; do sleep 1; done
sleep 1
docker exec -i "$NAME" psql -U postgres -v ON_ERROR_STOP=0 -f - < "$1"
