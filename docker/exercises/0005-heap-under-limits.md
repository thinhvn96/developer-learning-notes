# Exercise 0005: heap under limits

[Tiếng Việt](0005-heap-under-limits.vi.md)

Companion to [lesson 5](../lessons/0005-memory-cpu-limits-and-the-jvm.html).

1. Run `hello-multi` with `--memory` at 128m, 256m, 512m, 1g. Tabulate the max heap. At which point does the heap stop being about half?
2. Repeat with `-e JAVA_TOOL_OPTIONS=-XX:MaxRAMPercentage=75`.
3. Run with `--cpus=0.5`. What processor count does the JVM report?
4. Run with `-e JAVA_TOOL_OPTIONS=-Xlog:os+container=trace` and find the memory limit line the JVM logged.
