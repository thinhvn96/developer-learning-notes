# Bài tập 0009

Đi kèm [bài 9](../lessons/0009-configuration-properties-binding.vi.html) · [English](0009-typed-config.md)

Thêm `app.timeout` (kiểu `Duration`) và `app.retries` (có `@Min(1)`) vào `AppProperties`. Khởi động app với `app.retries=0` và đọc thông báo lỗi.
