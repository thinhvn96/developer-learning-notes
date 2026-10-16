# Exercise 0038: Size the cache

[Tiếng Việt](0038-size-the-cache.vi.md)

Companion to [lesson 38](../lessons/0038-capacity-boxing-and-memory.html).

1. A service keeps `Map<Long, Long>` of 20 million user ids to last-seen timestamps in memory. Estimate the memory order of magnitude from the measurements in the lesson. Propose two cheaper representations.
2. Run `CapacityAndBoxing.java` three times. Which numbers are stable and which are noisy? What tool would give you trustworthy numbers (name it, no need to use it)?
3. Explain the output `128 == 128: false` and find the bug: `if (order.getStatusCode() == response.getStatusCode())` where both return `Integer`.
4. `List<Integer> ids = new ArrayList<>(List.of(5, 1, 7)); ids.remove(1);` What is `ids` now? Write the line that removes the value 1.
