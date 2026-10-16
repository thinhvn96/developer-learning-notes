# Exercise 0001: break the write order

Companion to [lesson 1](../lessons/0001-cache-aside.html). · [Tiếng Việt](0001-break-the-write-order.vi.md)

In `CacheAsideDemo.java` swap the two lines in `write` (invalidate first, then update the store). Design a two-thread interleaving that leaves a stale value in the cache, and describe it step by step. Then add a TTL to the cache (a timestamp per entry) and show how it bounds the staleness.
