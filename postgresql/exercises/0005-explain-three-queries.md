# Exercise 0005: explain three queries

Companion to [lesson 5](../lessons/0005-reading-explain.html).

For each of these on the exercise 0004 tables, run `EXPLAIN ANALYZE` and write the plan's story in two sentences: (a) a lookup by primary key; (b) a filter on an unindexed column; (c) a join with an aggregate.

Then run `EXPLAIN ANALYZE` without running `ANALYZE` first on a freshly loaded table, run `ANALYZE`, and compare estimated vs actual rows.
