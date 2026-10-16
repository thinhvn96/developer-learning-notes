# Exercise 0015: Stop the rebalance storm

[Tiếng Việt](0015-stop-the-rebalance-storm.vi.md)

Companion to [lesson 15](../lessons/0015-rebalancing-and-group-protocols.html).

Symptoms: a 20-pod consumer deployment on Kafka 4.3 (classic protocol, default assignor). Every deploy causes 3 to 5 minutes of zero throughput, and lag spikes. Some days, a pod is kicked out of the group even though it is healthy.

1. Explain both symptoms using `partition.assignment.strategy`, `session.timeout.ms` and `max.poll.interval.ms`.
2. Give two fixes inside the classic protocol (name the configs and the rollout steps).
3. Give the fix with the new protocol: client config, broker requirement, what happens to `session.timeout.ms` in your config file, and how you would migrate without downtime.
4. Run `../examples/java-clients/run.sh` and point at the line showing which assignor the KIP-848 group used.
