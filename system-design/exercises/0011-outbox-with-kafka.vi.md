# Bài tập 0011

Đi kèm [bài 11](../lessons/0011-transactional-outbox.vi.html). · [English](0011-outbox-with-kafka.md)

Thiết kế relay từ `outbox` sang Kafka: polling so với change data capture (Kafka Connect), thứ tự theo từng aggregate, key cho idempotent consumer, và dọn dẹp các row đã publish.
