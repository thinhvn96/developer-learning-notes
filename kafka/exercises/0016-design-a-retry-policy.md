# Exercise 0016: Design a retry policy

[Tiếng Việt](0016-design-a-retry-policy.vi.md)

Companion to [lesson 16](../lessons/0016-error-handling-and-dead-letter-topics.html).

An `invoice` consumer calls (a) a tax service that sometimes times out, (b) its own database, and (c) validates that `amount > 0`.

1. Classify each failure as transient or permanent and give the handling for each.
2. Write the Spring `DefaultErrorHandler` bean: backoff, non-retryable exceptions, DLT.
3. Ordering matters per customer. Would you use `@RetryableTopic`? Explain with a concrete two-event example what could go wrong.
4. Records pile up in `invoice-dlt`. Describe the replay tool you would build: what it reads, what it checks before re-publishing, and how you avoid double-processing.
