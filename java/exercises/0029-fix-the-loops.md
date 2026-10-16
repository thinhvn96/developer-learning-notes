# Exercise 0029: Fix the loops

[Tiếng Việt](0029-fix-the-loops.vi.md)

Companion to [lesson 29](../lessons/0029-iterators-and-fail-fast.html).

Each snippet is buggy. Predict what happens (exception, wrong result or works by luck), then fix it two ways.

```java
// A
for (Order o : orders) if (o.isCancelled()) orders.remove(o);

// B
for (String key : prices.keySet()) if (prices.get(key) == 0) prices.remove(key);

// C
for (int i = 0; i < ids.size(); i++) if (ids.get(i) < 0) ids.remove(i);
```

1. Why does C not throw, and which element can it skip?
2. Write a 3-element list for which A completes without an exception. Why is that worse than an exception?
3. A teammate wraps A in `try { ... } catch (ConcurrentModificationException e) {}`. Quote the Javadoc sentence that says why this is wrong.
