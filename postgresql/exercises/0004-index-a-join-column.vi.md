# Bài tập 0004: đánh index cho cột join

Đi kèm [bài 4](../lessons/0004-indexes-what-they-buy.vi.html) · [English](0004-index-a-join-column.md)

1. Tạo `orders(id, customer_id, total)` với 500.000 dòng và `customers(id, name)` với 10.000 dòng (dùng `generate_series` và `random()`).
2. Chạy `EXPLAIN ANALYZE` cho query join hai table này cho một customer, trước và sau khi chạy `CREATE INDEX ON orders (customer_id)`.
3. Đo thời gian một lần `INSERT` hàng loạt 500.000 dòng khi có và khi không có index. Kết quả đó nói gì về chi phí của index?
