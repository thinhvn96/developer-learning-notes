# Exercise 0002: a three-way join

Companion to [lesson 2](../lessons/0002-joins-inner-and-left.html).

Using your library schema, list every member with their number of loans, including members who have never borrowed. Then:
1. Which join type did you need, and why?
2. Add a `WHERE` on `loans.returned_on IS NULL` and observe. What happened to members with no loans?
3. Fix it by moving the condition into `ON`.
