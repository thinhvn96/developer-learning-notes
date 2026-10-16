# Exercise 0037: Refactor to Map methods

[Tiếng Việt](0037-refactor-to-map-methods.vi.md)

Companion to [lesson 37](../lessons/0037-map-default-methods.html).

Rewrite each with one `Map` method call:

```java
// A
List<Order> list = byCustomer.get(c);
if (list == null) { list = new ArrayList<>(); byCustomer.put(c, list); }
list.add(order);

// B
Integer n = counts.get(word);
counts.put(word, n == null ? 1 : n + 1);

// C
if (stock.containsKey(sku)) {
    int left = stock.get(sku) - qty;
    if (left <= 0) stock.remove(sku); else stock.put(sku, left);
}
```

Then:
1. Why is `cache.putIfAbsent(key, loadFromDatabase(key))` wasteful? Rewrite it.
2. Your memoized recursive function throws `ConcurrentModificationException`. Why, and what is the fix?
3. On a `ConcurrentHashMap`, which of A, B and C become race-free after your rewrite?
