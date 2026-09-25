# Exercise 0025

Count words from 4 threads into a `ConcurrentHashMap<String, LongAdder>`. Then write the buggy `if (!map.containsKey(k)) map.put(k, 1)` version with `ConcurrentHashMap<String,Integer>` and show it losing counts.

Say your prediction to the teacher before running anything.
