# Exercise 0004: fix the pipeline

[Tiếng Việt](0004-fix-the-pipeline.vi.md)

Companion to [lesson 4](../lessons/0004-streams-and-optional.html). This code has three problems. Find them before running anything.

```java
List<String> names = List.of("ann", "bob", "cy");
List<String> out = new ArrayList<>();
Stream<String> s = names.stream().filter(n -> n.length() == 3);
s.forEach(n -> out.add(n.toUpperCase()));
System.out.println(s.count());
String first = out.stream().findFirst().orElse(loadDefaultFromDatabase());
```

Write a corrected version and say which sentence of the [stream package docs](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/package-summary.html) each fix relies on.
