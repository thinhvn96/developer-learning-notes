# Exercise 0023: Design disaster recovery

[Tiếng Việt](0023-design-dr.vi.md)

Companion to [lesson 23](../lessons/0023-multi-cluster-and-tiered-storage.html).

An order platform runs in Singapore and must survive losing the region. Business accepts losing at most 30 seconds of orders and 15 minutes of downtime.

1. Draw the MirrorMaker 2 topology (active/passive or active/active) and justify the choice.
2. After failover, the `fulfilment` consumer group starts in the standby region. Where does it resume reading, what mechanism makes that possible, and what duplicates should you expect?
3. Topic names in the standby have a prefix. How do your applications find the right topic after failover?
4. Retention requirement grows to 1 year for `orders` (non-compacted) and `customer-profile` (compacted). Which one can use tiered storage, and what local retention would you set?
