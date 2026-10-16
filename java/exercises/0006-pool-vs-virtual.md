# Exercise 0006: pool vs virtual

[Tiếng Việt](0006-pool-vs-virtual.vi.md)

Companion to [lesson 6](../lessons/0006-virtual-threads.html).

1. Copy `VirtualThreadsDemo.java` and replace the executor with `Executors.newFixedThreadPool(200)`. Predict the elapsed time first (10,000 tasks x 1 s / 200 threads).
2. Run it. Was your prediction right?
3. Now change the task from `Thread.sleep` to a CPU loop (for example summing to 2 billion). Compare virtual vs fixed pool sized to your core count. Which wins, and does that match the docs' "scale, not speed"?
4. Add a `Semaphore(50)` around the sleeping task in the virtual version to cap concurrency. What elapsed time do you expect?
