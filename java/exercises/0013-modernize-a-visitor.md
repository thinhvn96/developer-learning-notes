# Exercise 0013: modernize a cast chain

Companion to [lesson 13](../lessons/0013-switch-expressions-and-instanceof-patterns.html).

Modernize:
```java
static String label(Object o) {
    if (o instanceof Integer) { Integer i = (Integer) o; return "int " + (i + 1); }
    else if (o instanceof String) { String s = (String) o; return "str " + s.trim(); }
    return "other";
}
```
using `instanceof` patterns (JDK 17). Then rewrite `int daysIn(String month)` as a switch expression. Finally, say what the JDK 21 version of `label` would look like and why it needs a JDK 21 compiler.
