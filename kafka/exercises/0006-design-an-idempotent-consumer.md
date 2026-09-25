# Exercise 0006: design an idempotent consumer

Companion to [lesson 6](../lessons/0006-idempotence-and-transactions.html).

An `OrderPaid` event triggers an email and an inventory decrement. Design the consumer so redelivery cannot send two emails or decrement twice. Where do you store processed event ids, and inside which transaction (see the [PostgreSQL lessons](../../postgresql/index.html))?
