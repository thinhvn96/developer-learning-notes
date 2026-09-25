#!/usr/bin/env bash
# Usage: ./06-isolation.sh   Compares READ COMMITTED and REPEATABLE READ with two concurrent sessions.
set -euo pipefail
NAME=pg-iso-$$
docker run -d --rm --name "$NAME" -e POSTGRES_PASSWORD=example postgres:18 >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
until docker exec "$NAME" pg_isready -U postgres -h 127.0.0.1 >/dev/null 2>&1; do sleep 1; done
sleep 1
psql_() { docker exec -i "$NAME" psql -U postgres -At "$@"; }
psql_ -c "CREATE TABLE acct(id int PRIMARY KEY, balance int); INSERT INTO acct VALUES (1, 100);" >/dev/null

for level in "READ COMMITTED" "REPEATABLE READ"; do
  psql_ -c "UPDATE acct SET balance = 100 WHERE id = 1" >/dev/null
  echo "=== session A isolation level: $level"
  # Session A reads, waits 3 s, reads again.
  psql_ -c "BEGIN ISOLATION LEVEL $level; SELECT 'A first read : ' || balance FROM acct WHERE id=1; SELECT pg_sleep(3); SELECT 'A second read: ' || balance FROM acct WHERE id=1; COMMIT;" | grep '^A' &
  sleep 1
  # Session B commits a change while A's transaction is open.
  psql_ -c "UPDATE acct SET balance = 200 WHERE id = 1" >/dev/null
  echo "B committed balance = 200"
  wait
done
