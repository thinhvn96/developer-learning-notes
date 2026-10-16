# Exercise 0001: The key that changed

[Tiếng Việt](0001-mutable-key.vi.md)

Companion to [lesson 0001](../lessons/0001-hashmap-equals-hashcode.html). Write a `MutableKey` class with a non-final `id` field, and correct `equals` and `hashCode` based on `id`.

1. Put one `MutableKey("a")` into a `HashMap`, keeping a reference to the key.
2. Call `key.id = "b"`.
3. Predict, then check: what do `map.get(key)`, `map.containsKey(key)` and `map.size()` return? Can you get the entry back by any means other than iterating?
4. Write two sentences you could say in an interview explaining why immutable keys (`String`, `Integer`, records) are recommended.

Stretch: read the "Note: great care must be exercised if mutable objects are used as map keys" paragraph in the [`Map` Javadoc](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.html) and compare it with your answer.

Tell the teacher your prediction *before* you run the code.
