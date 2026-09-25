#!/usr/bin/env bash
# Usage: ./03-volumes-and-bind-mounts.sh
set -euo pipefail
VOL=lesson-vol-$$; DIR=$(mktemp -d)
trap 'docker volume rm "$VOL" >/dev/null 2>&1 || true; rm -rf "$DIR"' EXIT
echo "=== without a volume, data dies with the container"
docker run --name tmp-$$ alpine sh -c 'echo secret > /data.txt'
docker rm tmp-$$ >/dev/null
docker run --rm alpine sh -c 'cat /data.txt 2>&1 || true'
echo "=== named volume: data survives container removal"
docker volume create "$VOL" >/dev/null
docker run --rm --mount source="$VOL",target=/data alpine sh -c 'echo persisted > /data/file.txt'
docker run --rm --mount source="$VOL",target=/data alpine cat /data/file.txt
echo "=== bind mount: a host directory appears inside the container"
echo "from host" > "$DIR/host.txt"
docker run --rm --mount type=bind,src="$DIR",dst=/mnt alpine cat /mnt/host.txt
echo "=== readonly bind mount blocks writes"
docker run --rm --mount type=bind,src="$DIR",dst=/mnt,readonly alpine sh -c 'echo x > /mnt/new.txt' 2>&1 || true
