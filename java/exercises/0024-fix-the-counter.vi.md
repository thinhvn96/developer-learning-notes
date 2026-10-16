# Bài tập 0024

Đi kèm [bài 24](../lessons/0024-atomics-and-locks.vi.html). · [English](0024-fix-the-counter.md)

Chạy `AtomicDemo` năm lần và ghi lại số lần cập nhật bị mất của bản volatile. Thay `AtomicInteger` bằng `LongAdder` và so sánh thời gian chạy với 8 thread. Thêm một biến thể dùng `tryLock(10, ms)`.

Nói dự đoán của bạn cho giáo viên trước khi chạy bất cứ thứ gì.
