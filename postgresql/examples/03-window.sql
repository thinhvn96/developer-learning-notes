CREATE TABLE empsalary (depname text, empno int, salary int);
INSERT INTO empsalary VALUES
 ('develop', 11, 5200), ('develop', 7, 4200), ('develop', 9, 4500),
 ('sales', 1, 5000), ('sales', 4, 4800), ('sales', 3, 4800);

\echo '--- aggregate: one row per group'
SELECT depname, avg(salary) FROM empsalary GROUP BY depname ORDER BY depname;
\echo '--- window: every row kept, with the group average beside it'
SELECT depname, empno, salary, avg(salary) OVER (PARTITION BY depname)
FROM empsalary ORDER BY depname, empno;
\echo '--- row_number within each department by salary'
SELECT depname, empno, salary,
       row_number() OVER (PARTITION BY depname ORDER BY salary DESC)
FROM empsalary ORDER BY depname, row_number;
\echo '--- top earner per department (window inside a subquery)'
SELECT depname, empno, salary FROM (
  SELECT *, row_number() OVER (PARTITION BY depname ORDER BY salary DESC) AS rn FROM empsalary
) t WHERE rn = 1 ORDER BY depname;
