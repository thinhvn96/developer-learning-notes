# Bài tập 0011: Viết một Java client

[English](0011-write-a-java-client.md)

Bài tập đi kèm [bài 11](../lessons/0011-java-producer-and-consumer.vi.html).

1. Chạy `../examples/java-clients/run.sh`. Giải thích vì sao callback của `u2` in ra trước callback của `u1`, dù `u1` được gửi trước.
2. Sửa `OrderConsumer` để mỗi record mất 2 giây xử lý (`Thread.sleep`), rồi đặt `max.poll.records=500`, `max.poll.interval.ms=10000`. Dự đoán chuyện gì xảy ra trước khi chạy. Bạn sẽ đổi hai cấu hình nào để sửa, và mỗi thay đổi đánh đổi điều gì?
3. Một đồng nghiệp tạo một `KafkaProducer` mới bên trong mỗi HTTP request handler. Liệt kê hai vấn đề cụ thể của cách làm đó, có trích dẫn Javadoc.
4. Luyện phỏng vấn (nói to, 60 giây): "Hãy kể tôi nghe chuyện gì xảy ra từ lúc gọi `producer.send()` đến lúc record có thể được một consumer đọc."
