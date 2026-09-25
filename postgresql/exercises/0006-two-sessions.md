# Exercise 0006: two sessions

Companion to [lesson 6](../lessons/0006-mvcc-and-isolation-levels.html).

1. Run `./06-isolation.sh`. Read the script and explain each line of output.
2. Add a third variant with `SERIALIZABLE` where sessions A and B each read the other's row and then write, and see which one gets a serialization failure. (Hint: two accounts, each transaction reads the sum and updates its own row.)
3. What would your application code need to do on that failure?
