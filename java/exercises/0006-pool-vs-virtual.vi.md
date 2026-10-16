# Bài tập 0006: pool và virtual

Đi kèm [bài 6](../lessons/0006-virtual-threads.vi.html). · [English](0006-pool-vs-virtual.md)

1. Sao chép `VirtualThreadsDemo.java` và thay executor bằng `Executors.newFixedThreadPool(200)`. Dự đoán thời gian chạy trước (10.000 task x 1 s / 200 thread).
2. Chạy nó. Dự đoán của bạn có đúng không?
3. Giờ đổi task từ `Thread.sleep` sang một vòng lặp nặng CPU (ví dụ cộng dồn tới 2 tỷ). So sánh bản virtual với fixed pool có kích thước bằng số core của bạn. Bên nào thắng, và kết quả có khớp với câu "mở rộng, không phải tốc độ" trong tài liệu không?
4. Bọc một `Semaphore(50)` quanh task sleep trong bản virtual để giới hạn mức đồng thời. Bạn kỳ vọng thời gian chạy là bao nhiêu?
