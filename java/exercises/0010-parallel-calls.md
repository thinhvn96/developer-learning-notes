# Exercise 0010: parallel calls with a timeout

[Tiếng Việt](0010-parallel-calls.vi.md)

Companion to [lesson 10](../lessons/0010-completablefuture.html).

Simulate three slow services (sleep 300, 500, 800 ms). Call them with `supplyAsync`, combine with `allOf`, and time the total (predict it). Then make one throw; return a fallback with `exceptionally`. Finally run the same on `Executors.newFixedThreadPool(2)` with the three calls: what changes? Add `orTimeout` on JDK 9+ and say why the exercise still fits a JDK 8 baseline only up to that point.
