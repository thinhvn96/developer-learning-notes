#!/usr/bin/env bash
# Sourced by the numbered examples. Starts a throwaway single-node Kafka (KRaft) container
# and removes it on exit. Set PUBLISH=1 to expose port 9092 to the host (Java examples).
set -euo pipefail
NAME=kafka-lesson-$$
K=/opt/kafka/bin
BS="--bootstrap-server localhost:9092"
if [[ "${PUBLISH:-0}" == 1 ]]; then
  docker run -d --rm --name "$NAME" -p 9092:9092 apache/kafka:4.3.1 >/dev/null
else
  docker run -d --rm --name "$NAME" apache/kafka:4.3.1 >/dev/null
fi
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
until docker exec "$NAME" $K/kafka-topics.sh $BS --list >/dev/null 2>&1; do sleep 1; done
kx() { docker exec -i "$NAME" "$K/$1" "${@:2}"; }   # run a Kafka CLI tool inside the container
ksh() { docker exec -i "$NAME" sh -c "$1"; }         # run a shell command inside the container
