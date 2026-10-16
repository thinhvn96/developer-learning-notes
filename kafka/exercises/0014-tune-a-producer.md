# Exercise 0014: Tune a producer

[Tiếng Việt](0014-tune-a-producer.vi.md)

Companion to [lesson 14](../lessons/0014-producer-throughput-batching-compression.html).

1. Run `../examples/06-batching-and-compression.sh` twice. How stable are the numbers? Which conclusion survives the noise?
2. Add a run with `linger.ms=100 batch.size=1048576 compression.type=zstd`. Did throughput keep rising? Explain what limits it now.
3. Pick settings for: (a) a clickstream producer, 50k events/s, latency budget 1 s; (b) a payment command producer, 50 events/s, latency budget 50 ms. Justify each knob (`acks`, `linger.ms`, `batch.size`, `compression.type`, `enable.idempotence`).
4. Your service logs `TimeoutException: ... buffer` under load. Which config and which broker-side cause would you check first?
