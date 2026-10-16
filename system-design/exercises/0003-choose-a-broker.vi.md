# Bài tập 0003: chọn broker

Đi kèm [bài 3](../lessons/0003-queue-versus-log.vi.html). · [English](0003-choose-a-broker.md)

Với mỗi hệ thống dưới đây, hãy chọn RabbitMQ hoặc Kafka (hoặc không cái nào) và bảo vệ lựa chọn bằng hành vi đã được tài liệu hóa: (a) các job resize ảnh có retry và nơi lưu dead-letter; (b) một clickstream cung cấp dữ liệu độc lập cho analytics, phát hiện gian lận và search indexing; (c) các event order mà một service mới phải replay lại được từ tuần trước; (d) RPC kiểu request/response. Điều gì sẽ khiến bạn đổi ý?
