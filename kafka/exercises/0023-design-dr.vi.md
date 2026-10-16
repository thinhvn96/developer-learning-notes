# Bài tập 0023: Thiết kế disaster recovery

[English](0023-design-dr.md)

Bài tập đi kèm [bài 23](../lessons/0023-multi-cluster-and-tiered-storage.vi.html).

Một nền tảng đặt hàng chạy ở Singapore và phải sống sót khi mất cả region. Phía business chấp nhận mất tối đa 30 giây đơn hàng và 15 phút downtime.

1. Vẽ topology MirrorMaker 2 (active/passive hay active/active) và giải thích lựa chọn.
2. Sau failover, consumer group `fulfilment` khởi động ở region dự phòng. Nó tiếp tục đọc từ đâu, cơ chế nào giúp làm được điều đó, và bạn nên dự kiến những bản trùng lặp nào?
3. Tên topic ở cluster dự phòng có tiền tố. Ứng dụng của bạn tìm đúng topic sau failover bằng cách nào?
4. Yêu cầu retention tăng lên 1 năm cho `orders` (không compacted) và `customer-profile` (compacted). Topic nào dùng được tiered storage, và bạn sẽ đặt retention local bao nhiêu?
