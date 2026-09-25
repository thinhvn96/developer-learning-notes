CREATE TABLE v (id int PRIMARY KEY, val text) WITH (autovacuum_enabled = off);
INSERT INTO v SELECT g, 'row' FROM generate_series(1, 100000) g;
SELECT pg_stat_force_next_flush();
\echo '--- after 100k inserts'
SELECT n_live_tup, n_dead_tup FROM pg_stat_user_tables WHERE relname = 'v';
UPDATE v SET val = 'changed';
SELECT pg_stat_force_next_flush();
\echo '--- after updating every row: old row versions remain as dead tuples (MVCC)'
SELECT n_live_tup, n_dead_tup FROM pg_stat_user_tables WHERE relname = 'v';
\echo '--- table size before VACUUM'
SELECT pg_size_pretty(pg_relation_size('v'));
VACUUM v;
SELECT pg_stat_force_next_flush();
\echo '--- after VACUUM the dead tuples are recorded as reclaimed'
SELECT n_live_tup, n_dead_tup FROM pg_stat_user_tables WHERE relname = 'v';
\echo '--- DELETE and VACUUM FULL shrink the file'
DELETE FROM v WHERE id > 1000;
VACUUM FULL v;
SELECT pg_size_pretty(pg_relation_size('v'));
