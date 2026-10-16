# Java collections deepened into a 14-lesson track

The learner said the course covered collections too thinly (5 scattered lessons) and asked to go deeper. Collections are now a dedicated section of the Java ladder, in reading order: the framework map, lists, iterators and fail-fast, the equals/hashCode contract, HashMap internals, ordering (Comparable/Comparator), unmodifiable vs immutable, HashSet/LinkedHashMap/LRU, TreeMap/NavigableMap, PriorityQueue/top-K, special-purpose maps, Map default methods, capacity/boxing/memory, concurrent collections.

Implementation facts (treeification at 8 with table ≥ 64, `h ^ (h >>> 16)`, ArrayList's 1.5× growth) come from the OpenJDK 21 source, not from the Javadoc contract. Lessons label them that way, and the learner should too in interviews.

**Implications:** Collections are a common Senior-interview opener, so use this section for spaced retrieval (mix questions from 0029, 0030, 0031 and 0037 into later sessions). The learner's real level is still unknown: no exercise answers yet. Ask for exercise 0030 ("trace a put") as the first diagnostic.
