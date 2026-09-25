#!/usr/bin/env bash
# Usage: ./11-locking.sh   Row locks (SELECT FOR UPDATE) and a deadlock between two sessions.
set -euo pipefail
NAME=pg-lock-$$
docker run -d --rm --name "$NAME" -e POSTGRES_PASSWORD=example postgres:18 >/dev/null
trap 'docker rm -f "$NAME" >/dev/null 2>&1 || true' EXIT
until docker exec "$NAME" pg_isready -U postgres -h 127.0.0.1 >/dev/null 2>&1; do sleep 1; done; sleep 1
q() { docker exec -i "$NAME" psql -U postgres -At "$@"; }
q -c "CREATE TABLE acct(id int PRIMARY KEY, balance int); INSERT INTO acct VALUES (1,100),(2,100);" >/dev/null

echo "=== 1. SELECT ... FOR UPDATE makes another writer wait"
q -c "BEGIN; SELECT id FROM acct WHERE id=1 FOR UPDATE; SELECT pg_sleep(3); COMMIT;" >/dev/null &
sleep 1
START=$(date +%s.%N)
q -c "UPDATE acct SET balance = balance + 1 WHERE id = 1" >/dev/null
END=$(date +%s.%N)
wait
echo "second session UPDATE waited about $(python3 -c "print(round($END - $START,1))") s for the row lock"

echo "=== 2. deadlock: opposite update order"
q -c "BEGIN; UPDATE acct SET balance = balance - 10 WHERE id = 1; SELECT pg_sleep(2); UPDATE acct SET balance = balance + 10 WHERE id = 2; COMMIT;" >/tmp/dl1.$$ 2>&1 &
P1=$!
q -c "BEGIN; UPDATE acct SET balance = balance - 10 WHERE id = 2; SELECT pg_sleep(2); UPDATE acct SET balance = balance + 10 WHERE id = 1; COMMIT;" >/tmp/dl2.$$ 2>&1 &
P2=$!
wait $P1 || true; wait $P2 || true
grep -h "ERROR" /tmp/dl1.$$ /tmp/dl2.$$ | head -2 || true
rm -f /tmp/dl1.$$ /tmp/dl2.$$
echo "final balances:"; q -c "SELECT id, balance FROM acct ORDER BY id"
