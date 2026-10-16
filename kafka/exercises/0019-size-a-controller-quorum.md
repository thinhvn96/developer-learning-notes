# Exercise 0019: Size a controller quorum

[Tiếng Việt](0019-size-a-controller-quorum.vi.md)

Companion to [lesson 19](../lessons/0019-kraft-and-controllers.html).

1. Run `../examples/07-kraft-quorum.sh`. Is this quorum static or dynamic? How can you tell?
2. A team proposes 2 controllers "for redundancy" and another proposes 4. Explain why both are poor choices.
3. You have three racks (or availability zones). Place 3 controllers and 6 brokers. What survives losing one rack?
4. Interview drill: "Why did Kafka remove ZooKeeper?" Give an answer from what you learned, and say which part you would verify in the docs.
