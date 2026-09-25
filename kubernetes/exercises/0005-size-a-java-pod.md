# Exercise 0005: size a Java Pod

Companion to [lesson 5](../lessons/0005-requests-limits-and-the-jvm.html).

Your service uses about 300 MB heap and 100 MB non-heap at steady state, and spikes to 380 MB heap.
1. Choose memory request, memory limit and `MaxRAMPercentage`. Show your arithmetic.
2. Which of your choices would cause an OOM kill, and which would cause throttling?
3. Defend request = limit versus request < limit for memory in two sentences.
