# Exercise 0033: Build an LRU cache

[Tiếng Việt](0033-build-an-lru.vi.md)

Companion to [lesson 33](../lessons/0033-hashset-linkedhashmap-and-lru.html).

1. Extend `LruCache` so it also counts hits and misses. Which `LinkedHashMap` method calls count as an "access"?
2. Two request threads share one `LruCache`. Explain why even `get` needs synchronization in access-order mode, and wrap it correctly.
3. Without `LinkedHashMap`, design an LRU cache with a `HashMap` plus your own doubly linked list. What are the costs of get and put?
4. A teammate prints a `HashSet` in a test and asserts the string. The test passes locally and fails on CI. Explain with the Javadoc.
