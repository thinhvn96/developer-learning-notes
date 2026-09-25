# Exercise 0002: a retry budget

Companion to [lesson 2](../lessons/0002-retries-and-idempotency.html).

Service A calls B, B calls C; each layer retries 3 times. If C is down, how many calls does C receive per request to A? What does the docs' advice about a single retry layer change? Then make `RetryDemo` stop after a total time budget rather than attempt count.
