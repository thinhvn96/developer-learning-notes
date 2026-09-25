# Exercise 0005: write the error query

Companion to [lesson 5](../lessons/0005-query-dsl-term-match-bool.html).

Write a query: ERROR logs from service `orders` in the last 15 minutes that mention "timeout", excluding logs where `path` is `/health`. Say which clauses go in `filter`, `must`, `must_not` and why. Then break it by changing `message` to a `keyword` mapping and predict what `match` does.
