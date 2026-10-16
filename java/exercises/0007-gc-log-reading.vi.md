# Bài tập 0007: hai collector, một chương trình

Đi kèm [bài 7](../lessons/0007-heap-and-garbage-collection.vi.html). · [English](0007-gc-log-reading.md)

1. Chạy `java -Xmx64m -Xlog:gc java/examples/GcDemo.java` và ghi lại tên collector cùng một dòng pause.
2. Chạy lại với `-XX:+UseSerialGC`. Log khác gì?
3. Chạy với `-Xmx16m`. Số lần collection thay đổi thế nào? Vì sao?
4. Chạy không có `-Xmx` và đọc giá trị max heap được in ra. So sánh với 1/4 RAM của máy bạn (`free -m`). Có khớp với giá trị mặc định trong tài liệu không?
5. Sửa `sink = new byte[1024]` để mọi mảng đều được giữ lại trong một `ArrayList`. Chạy với `-Xmx64m`. Bạn gặp lỗi gì, và GC log diễn biến thế nào trước khi lỗi xảy ra?
