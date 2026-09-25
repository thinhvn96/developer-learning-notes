#!/usr/bin/env bash
# Usage: ./04-networks.sh   Compares the default bridge with a user-defined bridge.
set -euo pipefail
NET=lesson-net-$$
cleanup() { docker rm -f a-$$ b-$$ c-$$ d-$$ >/dev/null 2>&1 || true; docker network rm "$NET" >/dev/null 2>&1 || true; }
trap cleanup EXIT
echo "=== default bridge: reach by name?"
docker run -d --name a-$$ alpine sleep 60 >/dev/null
docker run -d --name b-$$ alpine sleep 60 >/dev/null
docker exec a-$$ ping -c1 -W2 b-$$ 2>&1 | head -1 || true
echo "=== user-defined bridge: reach by name?"
docker network create "$NET" >/dev/null
docker run -d --name c-$$ --network "$NET" alpine sleep 60 >/dev/null
docker run -d --name d-$$ --network "$NET" alpine sleep 60 >/dev/null
docker exec c-$$ ping -c1 -W2 d-$$ 2>&1 | head -2 || true
echo "=== isolation: c (user-defined) cannot reach b (default) by name"
docker exec c-$$ ping -c1 -W2 b-$$ 2>&1 | head -1 || true
