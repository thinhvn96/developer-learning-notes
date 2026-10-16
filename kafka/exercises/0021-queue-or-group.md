# Exercise 0021: Queue or group?

[Tiếng Việt](0021-queue-or-group.vi.md)

Companion to [lesson 21](../lessons/0021-share-groups.html).

1. Run `../examples/08-share-group.sh`. Rerun it with a consumer group instead (replace the share consumer with `kafka-console-consumer.sh --group workers`). What changes?
2. For each workload, choose consumer group or share group and justify it: (a) resize uploaded images; (b) apply ledger entries to account balances; (c) send push notifications; (d) build a search index from product changes.
3. A share-group worker crashes while holding 50 records. What happens to them, and after how long by default?
4. A record fails 5 times. What happens next? How does that compare to a DLT in a consumer-group design?
