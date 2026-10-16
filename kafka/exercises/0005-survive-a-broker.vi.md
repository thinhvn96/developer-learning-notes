# Bài tập 0005: sống sót khi một broker sập

[English](0005-survive-a-broker.md)

Bài tập đi kèm [bài 5](../lessons/0005-replication-isr-and-durability.vi.html).

Một topic có replication factor 3, `min.insync.replicas=2`, producer dùng `acks=all`. Hãy đi qua hai tình huống: (1) một broker chết, (2) hai broker chết. Topic còn ghi được không? Dữ liệu đã committed có bị mất không? Unclean leader election sẽ thay đổi điều gì? So sánh với `acks=1`.
