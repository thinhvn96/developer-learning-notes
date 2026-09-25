#!/usr/bin/env bash
# Usage: ./05-cmd-entrypoint-arg-env.sh
set -euo pipefail
cd "$(dirname "$0")/entrypoint-demo"
docker build -q --build-arg BUILD_ID=42 -t lesson-entry . >/dev/null
echo "=== default: ENTRYPOINT + CMD"
docker run --rm lesson-entry
echo "=== args after the image replace CMD only"
docker run --rm lesson-entry Docker
echo "=== --entrypoint replaces the ENTRYPOINT"
docker run --rm --entrypoint printenv lesson-entry APP_MODE
echo "=== ARG is not visible at runtime, ENV is"
docker run --rm --entrypoint sh lesson-entry -c 'echo "APP_MODE=$APP_MODE BUILD_ID=${BUILD_ID:-<unset>}"'
docker rmi lesson-entry >/dev/null
