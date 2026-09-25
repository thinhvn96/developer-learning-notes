# Exercise 0007: two collectors, one program

Companion to [lesson 7](../lessons/0007-heap-and-garbage-collection.html).

1. Run `java -Xmx64m -Xlog:gc java/examples/GcDemo.java` and note the collector name and one pause line.
2. Run again with `-XX:+UseSerialGC`. What differs in the log?
3. Run with `-Xmx16m`. What happens to the number of collections? Why?
4. Run without `-Xmx` and read the printed max heap. Compare it with 1/4 of your machine's RAM (`free -m`). Does it match the documented default?
5. Change `sink = new byte[1024]` so every array is kept in an `ArrayList`. Run with `-Xmx64m`. What error do you get, and how does the GC log lead up to it?
