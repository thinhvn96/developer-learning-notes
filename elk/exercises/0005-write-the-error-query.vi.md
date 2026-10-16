# Bài tập 0005: viết query tìm lỗi

Bài tập đi kèm [bài 5](../lessons/0005-query-dsl-term-match-bool.vi.html). · [English](0005-write-the-error-query.md)

Viết một query: các log ERROR từ service `orders` trong 15 phút gần nhất có nhắc tới "timeout", loại trừ những log có `path` là `/health`. Nói rõ mệnh đề nào đặt trong `filter`, `must`, `must_not` và vì sao. Sau đó cố tình làm hỏng nó bằng cách đổi mapping của `message` thành `keyword` và dự đoán `match` sẽ làm gì.
