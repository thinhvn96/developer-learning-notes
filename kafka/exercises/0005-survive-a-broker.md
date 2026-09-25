# Exercise 0005: survive a broker failure

Companion to [lesson 5](../lessons/0005-replication-isr-and-durability.html).

A topic has replication factor 3, `min.insync.replicas=2`, producers use `acks=all`. Walk through: (1) one broker dies, (2) two brokers die. Is the topic writable? Is committed data lost? What would unclean leader election change? Compare with `acks=1`.
