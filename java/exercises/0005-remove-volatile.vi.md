# Bài tập 0005: bỏ volatile và quan sát

Đi kèm [bài 5](../lessons/0005-visibility-and-happens-before.vi.html). · [English](0005-remove-volatile.md)

1. Chạy `java java/examples/StopFlag.java`. Chương trình phải kết thúc.
2. Xóa `volatile` khỏi `stop` và chạy 5 lần. Ghi lại chuyện xảy ra mỗi lần (script sẽ thoát với status 1 nếu worker không bao giờ dừng).
3. Giải thích kết quả, dùng các từ "data race" và "happens-before". Vì sao "chạy được 5 trên 5 lần" không phải là bằng chứng cho tính đúng đắn?
4. Khôi phục thứ tự *mà không dùng* `volatile`, bằng một cạnh happens-before khác trong bài (gợi ý: `synchronized`, hoặc `AtomicBoolean`). Bạn đã chọn cạnh nào?
