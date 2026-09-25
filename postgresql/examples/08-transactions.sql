CREATE TABLE accounts (name text PRIMARY KEY, balance numeric NOT NULL CHECK (balance >= 0));
INSERT INTO accounts VALUES ('Alice', 100), ('Bob', 50), ('Wally', 0);

\echo '--- COMMIT: both updates or neither'
BEGIN;
UPDATE accounts SET balance = balance - 30 WHERE name = 'Alice';
UPDATE accounts SET balance = balance + 30 WHERE name = 'Bob';
COMMIT;
SELECT * FROM accounts ORDER BY name;

\echo '--- a failure aborts the whole transaction: the CHECK constraint rejects the 2nd update'
BEGIN;
UPDATE accounts SET balance = balance + 500 WHERE name = 'Bob';
UPDATE accounts SET balance = balance - 500 WHERE name = 'Alice';
COMMIT;
SELECT * FROM accounts ORDER BY name;

\echo '--- ROLLBACK discards everything'
BEGIN;
UPDATE accounts SET balance = 0 WHERE name = 'Alice';
ROLLBACK;
SELECT * FROM accounts WHERE name = 'Alice';

\echo '--- SAVEPOINT: undo only part of a transaction'
BEGIN;
UPDATE accounts SET balance = balance - 10 WHERE name = 'Alice';
SAVEPOINT s1;
UPDATE accounts SET balance = balance + 10 WHERE name = 'Bob';
ROLLBACK TO s1;
UPDATE accounts SET balance = balance + 10 WHERE name = 'Wally';
COMMIT;
SELECT * FROM accounts ORDER BY name;
