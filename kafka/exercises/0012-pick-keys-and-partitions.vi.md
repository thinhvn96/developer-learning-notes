# Bài tập 0012: Chọn key và số partition

[English](0012-pick-keys-and-partitions.md)

Bài tập đi kèm [bài 12](../lessons/0012-partitioning-and-partition-count.vi.html).

1. Chạy `../examples/05-add-partitions.sh`. Những key nào đã bị dời đi, và vì sao một số key không bị dời?
2. Chọn key cho từng topic và giải thích trong một câu: `payments` (cập nhật số dư theo từng tài khoản), `page-views` (analytics, không cần thứ tự), `order-status` (state machine theo từng đơn hàng), `country-metrics` (mỗi quốc gia một event mỗi phút).
3. `order-status` phải chịu được 3.000 event/s lúc cao điểm trong hai năm tới. Một instance consumer xử lý được 200 event/s. Hôm nay bạn sẽ tạo bao nhiêu partition, và vì sao không "cứ thêm sau"?
4. Topic có key của bạn đang có 12 partition và cần tăng lên 48. Viết kế hoạch migration (topic mới, dual write hoặc cut-over, chuyển consumer) sao cho không có đơn hàng nào bị xử lý event sai thứ tự.
