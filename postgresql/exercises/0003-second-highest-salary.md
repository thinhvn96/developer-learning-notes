# Exercise 0003: second highest per department

Companion to [lesson 3](../lessons/0003-window-functions.html).

1. On `empsalary` from the example, return the second highest salary per department.
2. Ties: employees 4 and 3 in sales both earn 4800. Compare `row_number()`, `rank()` and `dense_rank()` on that data. Which fits "second highest salary" and why?
3. Add a column showing each employee's difference from their department average, without a GROUP BY.
