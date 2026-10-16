# Exercise 0017: compare G1 and ZGC

[Tiếng Việt](0017-compare-g1-and-zgc.vi.md)

Companion to [lesson 17](../lessons/0017-generational-zgc.html).

Run `GcDemo` with G1 (default), then `-XX:+UseZGC -XX:+ZGenerational`, with `-Xmx64m -Xlog:gc`. Record the collector line, number of collections, and the reported pause times. Then change the program so it keeps 30 MB of live data. Which collector's log changes more? Write two sentences an interviewer would accept about when you would switch collectors.
