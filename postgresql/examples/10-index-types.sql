CREATE TABLE t (a int, b int, c int, status text, tags text[]);
INSERT INTO t SELECT g % 100, g % 1000, g, CASE WHEN g % 100 = 0 THEN 'rare' ELSE 'common' END, ARRAY['x' || (g % 50)] FROM generate_series(1, 200000) g;
ANALYZE t;

\echo '--- multicolumn index (a, b): leading column constrained'
CREATE INDEX t_ab ON t (a, b);
ANALYZE t;
EXPLAIN (COSTS OFF) SELECT * FROM t WHERE a = 5 AND b = 505;
\echo '--- only the second column constrained (leading column missing)'
EXPLAIN (COSTS OFF) SELECT * FROM t WHERE b = 505;

\echo '--- partial index only over the rare rows'
CREATE INDEX t_rare ON t (c) WHERE status = 'rare';
ANALYZE t;
SELECT pg_size_pretty(pg_relation_size('t_ab')) AS multicolumn_index, pg_size_pretty(pg_relation_size('t_rare')) AS partial_index;
EXPLAIN (COSTS OFF) SELECT * FROM t WHERE status = 'rare' AND c = 300;

\echo '--- GIN index for array containment'
CREATE INDEX t_tags ON t USING GIN (tags);
ANALYZE t;
EXPLAIN (COSTS OFF) SELECT count(*) FROM t WHERE tags @> ARRAY['x7'];
