# Exercise 0028: Pick the structure

[Tiếng Việt](0028-pick-the-structure.vi.md)

Companion to [lesson 28](../lessons/0028-collections-framework-map.html).

For each requirement name the interface you would declare and the implementation you would create, and say which of the three questions (duplicates? order? keyed lookup?) decided it.

1. The last 50 page views of a user, newest first.
2. All distinct tags on a blog, printed alphabetically.
3. Product price by SKU, looked up on every request.
4. Jobs waiting to run, always the earliest deadline next.
5. The order in which a user added items to a cart, without duplicates.
6. A browser's back button history.

Then run `java java/examples/collections/FrameworkMap.java` and explain why `PriorityQueue` is not a `SequencedCollection`.
