# Exercise 0001: model a library

Companion to [lesson 1](../lessons/0001-tables-and-constraints.html).

Design tables `authors`, `books`, `members`, `loans`. Requirements: an ISBN is unique; a member has one email; a loan cannot reference a missing book or member; a book cannot be deleted while loans exist; a loan's return date cannot precede its loan date.

Write the DDL, then write five deliberately bad inserts, one per constraint kind, and run them with `./run.sh`. Predict each error message first.
