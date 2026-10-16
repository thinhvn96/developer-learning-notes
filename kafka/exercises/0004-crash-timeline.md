# Exercise 0004: crash timeline

[Tiếng Việt](0004-crash-timeline.vi.md)

Companion to [lesson 4](../lessons/0004-delivery-semantics.html).

Draw a timeline for a consumer that: polls a record, writes to a database, commits the offset. Insert a crash at each of the three gaps. For each, say what the next consumer sees, and which delivery guarantee results. Then redesign step 2 to be idempotent.
