# Exercise 0011: Write a Java client

[Tiếng Việt](0011-write-a-java-client.vi.md)

Companion to [lesson 11](../lessons/0011-java-producer-and-consumer.html).

1. Run `../examples/java-clients/run.sh`. Explain why the `u2` callbacks printed before the `u1` callbacks even though `u1` was sent first.
2. Change `OrderConsumer` so processing one record takes 2 seconds (`Thread.sleep`) and set `max.poll.records=500`, `max.poll.interval.ms=10000`. Predict what happens before you run it. Which two settings would you change to fix it, and what does each trade off?
3. A teammate creates a new `KafkaProducer` inside every HTTP request handler. List two concrete problems with that, citing the Javadoc.
4. Interview drill (out loud, 60 seconds): "Walk me through what happens between `producer.send()` and the record being readable by a consumer."
