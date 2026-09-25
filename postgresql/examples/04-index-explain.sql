CREATE TABLE test1 (id integer, content varchar);
INSERT INTO test1 SELECT g, 'row ' || g FROM generate_series(1, 200000) g;
ANALYZE test1;

\echo '--- before the index'
EXPLAIN ANALYZE SELECT content FROM test1 WHERE id = 123456;

CREATE INDEX test1_id_index ON test1 (id);
ANALYZE test1;

\echo '--- after the index'
EXPLAIN ANALYZE SELECT content FROM test1 WHERE id = 123456;

\echo '--- EXPLAIN ANALYZE really executes DML; roll it back'
BEGIN;
EXPLAIN ANALYZE UPDATE test1 SET content = 'changed' WHERE id < 100;
ROLLBACK;
SELECT count(*) AS changed_rows_after_rollback FROM test1 WHERE content = 'changed';
