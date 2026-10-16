# Exercise 0012: Pick keys and a partition count

[Tiếng Việt](0012-pick-keys-and-partitions.vi.md)

Companion to [lesson 12](../lessons/0012-partitioning-and-partition-count.html).

1. Run `../examples/05-add-partitions.sh`. Which keys moved, and why did some not move?
2. Choose a key for each topic and justify it in one sentence: `payments` (per-account balance updates), `page-views` (analytics, no ordering need), `order-status` (state machine per order), `country-metrics` (one event per country per minute).
3. `order-status` must handle 3,000 events/s at peak in two years. One consumer instance processes 200 events/s. How many partitions would you create today, and why not "just add more later"?
4. Your keyed topic has 12 partitions and must grow to 48. Write the migration plan (new topic, dual write or cut-over, consumer switch) so no order's events are processed out of order.
