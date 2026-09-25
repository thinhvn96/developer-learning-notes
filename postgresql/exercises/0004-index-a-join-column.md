# Exercise 0004: index a join column

Companion to [lesson 4](../lessons/0004-indexes-what-they-buy.html).

1. Create `orders(id, customer_id, total)` with 500,000 rows and `customers(id, name)` with 10,000 rows (`generate_series` and `random()`).
2. `EXPLAIN ANALYZE` the query joining them for one customer, before and after `CREATE INDEX ON orders (customer_id)`.
3. Time a bulk `INSERT` of 500,000 rows with and without the index. What does that show about the cost of indexes?
