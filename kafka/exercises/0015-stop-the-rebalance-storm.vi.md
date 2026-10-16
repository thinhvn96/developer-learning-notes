# Bài tập 0015: Dập tắt cơn bão rebalance

[English](0015-stop-the-rebalance-storm.md)

Bài tập đi kèm [bài 15](../lessons/0015-rebalancing-and-group-protocols.vi.html).

Triệu chứng: một deployment consumer 20 pod chạy trên Kafka 4.3 (giao thức classic, assignor mặc định). Mỗi lần deploy là 3 đến 5 phút throughput bằng không, và lag tăng vọt. Có những ngày, một pod bị đá khỏi group dù nó vẫn khoẻ mạnh.

1. Giải thích cả hai triệu chứng dựa trên `partition.assignment.strategy`, `session.timeout.ms` và `max.poll.interval.ms`.
2. Đưa ra hai cách khắc phục trong phạm vi giao thức classic (nêu tên config và các bước rollout).
3. Đưa ra cách khắc phục bằng giao thức mới: config phía client, yêu cầu phía broker, chuyện gì xảy ra với `session.timeout.ms` trong file config của bạn, và bạn migrate thế nào để không có downtime.
4. Chạy `../examples/java-clients/run.sh` và chỉ ra dòng cho biết group KIP-848 đã dùng assignor nào.
