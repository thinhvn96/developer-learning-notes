# Exercise 0003: tune prefetch

Companion to [lesson 3](../lessons/0003-acks-prefetch-redelivery.html).

Two workers process jobs taking 10 ms and 1000 ms. Explain what happens with prefetch 100 versus prefetch 1 for the slow worker. Which gives better fairness, which better throughput? Cite the confirms page for the recommended range and say why it might not suit uneven jobs.
