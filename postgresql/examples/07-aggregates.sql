CREATE TABLE weather (city text, temp_lo int, temp_hi int);
INSERT INTO weather VALUES ('Hayward', 37, 54), ('Hayward', 40, 55), ('San Francisco', 46, 50), ('San Francisco', 43, 57), ('Oakland', 35, 45);

\echo '--- aggregate over all rows: one row'
SELECT count(*), max(temp_lo), avg(temp_hi) FROM weather;
\echo '--- GROUP BY: one row per city'
SELECT city, count(*), max(temp_lo) FROM weather GROUP BY city ORDER BY city;
\echo '--- WHERE filters rows BEFORE grouping'
SELECT city, count(*) FROM weather WHERE temp_lo < 40 GROUP BY city ORDER BY city;
\echo '--- HAVING filters groups AFTER aggregation'
SELECT city, max(temp_lo) FROM weather GROUP BY city HAVING max(temp_lo) < 40 ORDER BY city;
\echo '--- aggregates are not allowed in WHERE (this must fail):'
SELECT city FROM weather WHERE temp_lo = max(temp_lo);
\echo '--- use a subquery instead:'
SELECT city FROM weather WHERE temp_lo = (SELECT max(temp_lo) FROM weather);
