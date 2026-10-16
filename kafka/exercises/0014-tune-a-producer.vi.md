# Bài tập 0014: Tinh chỉnh một producer

[English](0014-tune-a-producer.md)

Bài tập đi kèm [bài 14](../lessons/0014-producer-throughput-batching-compression.vi.html).

1. Chạy `../examples/06-batching-and-compression.sh` hai lần. Số liệu ổn định đến mức nào? Kết luận nào vẫn đứng vững trước nhiễu?
2. Thêm một lượt chạy với `linger.ms=100 batch.size=1048576 compression.type=zstd`. Throughput có tiếp tục tăng không? Giải thích cái gì đang giới hạn nó lúc này.
3. Chọn cấu hình cho: (a) một producer clickstream, 50k event/s, ngân sách latency 1 s; (b) một producer gửi lệnh thanh toán, 50 event/s, ngân sách latency 50 ms. Giải thích lý do cho từng nút vặn (`acks`, `linger.ms`, `batch.size`, `compression.type`, `enable.idempotence`).
4. Service của bạn log ra `TimeoutException: ... buffer` khi tải cao. Bạn sẽ kiểm tra config nào và nguyên nhân phía broker nào trước tiên?
