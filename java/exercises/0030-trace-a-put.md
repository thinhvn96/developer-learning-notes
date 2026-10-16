# Exercise 0030: Trace a put

[Tiếng Việt](0030-trace-a-put.vi.md)

Companion to [lesson 30](../lessons/0030-hashmap-internals.html).

1. By hand (then check with a small program): a `HashMap` with default settings receives keys `"Aa"`, `"BB"` and `"apple"`. For each, compute the spread hash and the bucket index. Which keys share a bucket?
2. After how many entries does a default `HashMap` resize the first time? The second time?
3. You put 1,000,000 entries into `new HashMap<>()`. Roughly how many resizes happen? Rewrite the line for JDK 8 and for JDK 21 so none happen.
4. Run `HashMapInternals.java`. Explain the 50× difference with the words "bin", "tree" and "Comparable".
5. Interview drill (90 seconds, out loud): "What happens when I call `map.put(k, v)`?"
