# Bài tập 0016: Thiết kế một chính sách retry

[English](0016-design-a-retry-policy.md)

Bài tập đi kèm [bài 16](../lessons/0016-error-handling-and-dead-letter-topics.vi.html).

Một consumer `invoice` gọi (a) một tax service thỉnh thoảng bị timeout, (b) database của chính nó, và (c) validate rằng `amount > 0`.

1. Phân loại từng lỗi là tạm thời hay vĩnh viễn và nêu cách xử lý cho mỗi loại.
2. Viết bean `DefaultErrorHandler` của Spring: backoff, các exception không retry, DLT.
3. Thứ tự theo từng khách hàng là quan trọng. Bạn có dùng `@RetryableTopic` không? Giải thích bằng một ví dụ cụ thể với hai event xem chuyện gì có thể sai.
4. Record dồn ứ trong `invoice-dlt`. Mô tả công cụ replay bạn sẽ xây: nó đọc gì, kiểm tra gì trước khi publish lại, và bạn tránh xử lý trùng bằng cách nào.
