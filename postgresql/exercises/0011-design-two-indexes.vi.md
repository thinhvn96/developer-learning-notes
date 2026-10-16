# Bài tập 0011

Đi kèm [bài 11](../lessons/0011-multicolumn-and-partial-indexes.vi.html) · [English](0011-design-two-indexes.md)

Với `orders(customer_id, status, created_at)` và các query (1) theo customer và một khoảng ngày, (2) chỉ các đơn hàng đang mở (5% số dòng) theo ngày: thiết kế một index nhiều cột và một partial index, rồi kiểm chứng bằng EXPLAIN.
