# Exercise 0020: Write an on-call runbook

[Tiếng Việt](0020-on-call-runbook.vi.md)

Companion to [lesson 20](../lessons/0020-monitoring-and-operations.html).

Write a one-page runbook with, for each alert: what it means, the first command you run, and the likely causes.

1. `UnderReplicatedPartitions > 0` for 10 minutes.
2. `UnderMinIsrPartitionCount > 0`, and producers with `acks=all` log `NotEnoughReplicasException`.
3. Consumer group `billing` lag growing for 30 minutes, broker metrics normal.
4. `RequestHandlerAvgIdlePercent` at 0.05 on one broker only.

Finish with the steps for a rolling broker restart and the condition you wait for between brokers.
