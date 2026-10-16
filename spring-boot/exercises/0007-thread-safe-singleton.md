# Exercise 0007

[Tiếng Việt](0007-thread-safe-singleton.vi.md)

A singleton service keeps a `List<String> lastRequests` field. Why is it a bug under load? Fix it three ways (make it stateless, use a concurrent collection, or use a request-scoped/prototype bean) and state the trade-off of each.
