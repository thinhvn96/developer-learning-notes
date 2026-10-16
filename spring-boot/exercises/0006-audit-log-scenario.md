# Exercise 0006: the audit-log scenario

[Tiếng Việt](0006-audit-log-scenario.vi.md)

Companion to [lesson 6](../lessons/0006-transaction-propagation.html).

`placeOrder()` must save an audit record even when the order fails. Which propagation mode for the audit method? Where must the audit method live so the proxy applies? How many DB connections does one request hold at peak, and what does that mean for the pool size?
