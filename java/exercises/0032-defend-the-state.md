# Exercise 0032: Defend the state

[Tiếng Việt](0032-defend-the-state.vi.md)

Companion to [lesson 32](../lessons/0032-unmodifiable-vs-immutable.html).

```java
public class Cart {
    private final List<Item> items = new ArrayList<>();
    public List<Item> getItems() { return items; }
}
```

1. Show two ways a caller can corrupt `Cart` through `getItems()`.
2. Fix it three ways: `Collections.unmodifiableList(items)`, `List.copyOf(items)`, `new ArrayList<>(items)`. For each, what does the caller see if the cart changes later, and what does it cost?
3. `Item` has a mutable `quantity` field. Which of your fixes still leak? What would make the cart truly immutable?
4. Predict, then run: `Arrays.asList(1, 2, 3).add(4)`, `List.of(1, 2).contains(null)`, `Map.of("a", 1, "a", 2)`.
