# Exercise 0039: Pick the concurrent structure

[Tiếng Việt](0039-pick-the-concurrent-structure.vi.md)

Companion to [lesson 39](../lessons/0039-concurrent-collections.html).

For each, choose the structure and the exact methods:

1. Event listeners registered at startup, notified on every request by many threads.
2. A request counter per endpoint updated by 200 threads.
3. Price levels in an order book, read by range, updated concurrently.
4. A pipeline: 4 threads parse files, 2 threads write to the database; parsing must slow down when the writers fall behind.
5. A list of active sessions, iterated every minute by a cleanup job and modified by request threads.

Then: in the lesson's run the plain `ArrayList` ended with 13,243 elements and no exception. Explain where the other 26,757 adds went.
