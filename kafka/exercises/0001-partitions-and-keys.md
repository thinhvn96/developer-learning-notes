# Exercise 0001: partitions and keys

Companion to [lesson 1](../lessons/0001-events-topics-partitions.html).

1. Run `./01-topics-keys-groups.sh`. Which partition did each key land on?
2. Change the topic to 1 partition and rerun. What changes about ordering across keys?
3. Explain why you would use `userId` as the key for user events but not a random UUID.
4. What happens to ordering guarantees if you later increase the partition count of a topic with keyed data? Look for the answer in the docs; say what you could not find.
