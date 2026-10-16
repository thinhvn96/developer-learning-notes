# Bài tập 0005: retry queue dùng TTL

Bài tập đi kèm [bài 5](../lessons/0005-dead-letter-exchanges.vi.html). · [English](0005-retry-queue-with-ttl.md)

Thiết kế một cơ chế retry có độ trễ: message xử lý lỗi được đưa vào queue `retry` có TTL, hết hạn rồi được dead-letter quay lại exchange chính. Vẽ ra các exchange, queue và argument. Điều gì giới hạn số vòng lặp một message có thể đi qua, và sau đó chuyện gì xảy ra?
