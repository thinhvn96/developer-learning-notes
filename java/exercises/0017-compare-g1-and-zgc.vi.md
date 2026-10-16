# Bài tập 0017: so sánh G1 và ZGC

Đi kèm [bài 17](../lessons/0017-generational-zgc.vi.html). · [English](0017-compare-g1-and-zgc.md)

Chạy `GcDemo` với G1 (mặc định), rồi với `-XX:+UseZGC -XX:+ZGenerational`, đều kèm `-Xmx64m -Xlog:gc`. Ghi lại dòng tên collector, số lần collection, và các thời gian pause được báo cáo. Sau đó sửa chương trình để nó giữ 30 MB dữ liệu sống. Log của collector nào thay đổi nhiều hơn? Viết hai câu mà interviewer sẽ chấp nhận về việc khi nào bạn đổi collector.
