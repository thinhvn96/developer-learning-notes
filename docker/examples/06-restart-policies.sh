#!/usr/bin/env bash
# Usage: ./06-restart-policies.sh   Containers that exit with code 1, under different restart policies.
set -euo pipefail
cleanup() { docker rm -f r-no-$$ r-fail-$$ >/dev/null 2>&1 || true; }
trap cleanup EXIT
docker run -d --name r-no-$$   alpine sh -c 'exit 1' >/dev/null
docker run -d --name r-fail-$$ --restart on-failure:3 alpine sh -c 'exit 1' >/dev/null
sleep 12
for n in r-no-$$ r-fail-$$; do
  docker inspect -f '{{.Name}} policy={{.HostConfig.RestartPolicy.Name}} restarts={{.RestartCount}} state={{.State.Status}} exit={{.State.ExitCode}}' "$n"
done
