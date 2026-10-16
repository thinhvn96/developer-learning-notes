# Exercise 0018: Build a fraud window

[Tiếng Việt](0018-fraud-window.vi.md)

Companion to [lesson 18](../lessons/0018-streams-windows-joins-exactly-once.html).

Requirement: flag a card if it makes more than 5 payments within any 1-minute period. Payments can arrive up to 20 seconds late.

1. Tumbling, hopping, sliding or session window: which one matches "any 1-minute period", and why do tumbling windows miss some cases?
2. Write the DSL (key, windowing with grace, count, filter, output topic).
3. You want to enrich each flagged card with the customer's risk tier from a `customers` topic (2 million rows, 6 partitions). The `payments` topic has 24 partitions. Which join do you use, and what would break with a `KTable` join?
4. Do you need `exactly_once_v2` here? What could happen downstream without it?
