# Exercise 0005: a retry queue with TTL

Companion to [lesson 5](../lessons/0005-dead-letter-exchanges.html).

Design a delayed retry: failed messages go to a `retry` queue with a TTL, expire, and are dead-lettered back to the main exchange. Draw the exchanges, queues and arguments. What limits how many times a message can loop, and what happens after that?
