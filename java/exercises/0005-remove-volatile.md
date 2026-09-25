# Exercise 0005: remove volatile and observe

Companion to [lesson 5](../lessons/0005-visibility-and-happens-before.html).

1. Run `java java/examples/StopFlag.java`. It should finish.
2. Delete `volatile` from `stop` and run it 5 times. Record what happens each time (the script exits with status 1 if the worker never stops).
3. Explain the result using the words "data race" and "happens-before". Why is "it worked 5 out of 5 times" not evidence of correctness?
4. Restore ordering *without* `volatile`, using a different happens-before edge from the lesson (hint: `synchronized`, or `AtomicBoolean`). Which edge did you pick?
