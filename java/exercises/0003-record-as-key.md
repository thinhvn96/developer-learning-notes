# Exercise 0003: a record as a map key

Companion to [lesson 3](../lessons/0003-records-and-immutability.html) and [lesson 1](../lessons/0001-hashmap-equals-hashcode.html).

1. Write `record Coord(int row, int col)`. Put `new Coord(1, 2)` in a `HashMap<Coord,String>`, then look it up with a different `new Coord(1, 2)`. Predict the result first.
2. Change one component to `List<Integer> path`. Put an entry in, mutate the list, and look it up again. What happens, and why does lesson 1 explain it?
3. Fix it with a compact constructor. Does the fix also protect against the caller keeping a reference to the original list?
