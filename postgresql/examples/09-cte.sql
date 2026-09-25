CREATE TABLE orders (region text, product text, quantity int, amount numeric);
INSERT INTO orders VALUES ('eu','pen',10,20),('eu','ink',5,50),('us','pen',100,200),('us','ink',50,500),('asia','pen',1,2);

\echo '--- WITH: named intermediate results'
WITH regional_sales AS (
    SELECT region, SUM(amount) AS total_sales FROM orders GROUP BY region
), top_regions AS (
    SELECT region FROM regional_sales WHERE total_sales > (SELECT SUM(total_sales)/10 FROM regional_sales)
)
SELECT region, product, SUM(quantity) AS units FROM orders
WHERE region IN (SELECT region FROM top_regions) GROUP BY region, product ORDER BY region, product;

\echo '--- WITH RECURSIVE: sum 1..100'
WITH RECURSIVE t(n) AS (VALUES (1) UNION ALL SELECT n+1 FROM t WHERE n < 100)
SELECT sum(n) FROM t;

\echo '--- WITH RECURSIVE over a hierarchy: an employee and all managers above'
CREATE TABLE emp (id int PRIMARY KEY, name text, manager_id int REFERENCES emp(id));
INSERT INTO emp VALUES (1,'ceo',NULL),(2,'vp',1),(3,'lead',2),(4,'dev',3);
WITH RECURSIVE chain AS (
    SELECT id, name, manager_id, 0 AS level FROM emp WHERE name = 'dev'
  UNION ALL
    SELECT e.id, e.name, e.manager_id, c.level + 1 FROM emp e JOIN chain c ON e.id = c.manager_id
)
SELECT level, name FROM chain ORDER BY level;
