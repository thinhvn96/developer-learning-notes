# Bài tập 0020: Viết runbook cho on-call

[English](0020-on-call-runbook.md)

Bài tập đi kèm [bài 20](../lessons/0020-monitoring-and-operations.vi.html).

Viết một runbook dài một trang, với mỗi cảnh báo nêu: ý nghĩa của nó, lệnh đầu tiên bạn chạy, và các nguyên nhân có khả năng nhất.

1. `UnderReplicatedPartitions > 0` kéo dài 10 phút.
2. `UnderMinIsrPartitionCount > 0`, và các producer dùng `acks=all` log ra `NotEnoughReplicasException`.
3. Lag của consumer group `billing` tăng suốt 30 phút, metric của broker vẫn bình thường.
4. `RequestHandlerAvgIdlePercent` ở mức 0.05 trên chỉ một broker.

Kết thúc bằng các bước rolling restart broker và điều kiện bạn chờ giữa hai broker.
