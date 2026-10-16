# Bài tập 0035: Top-K và lập lịch

[English](0035-top-k-and-scheduling.md)

Đi kèm [bài 35](../lessons/0035-priorityqueue-and-top-k.vi.html).

1. Trả về 10 từ xuất hiện nhiều nhất trong một file log 2 GB. Kết hợp `merge` (để đếm) với một heap. Heap loại nào, kích thước bao nhiêu, comparator nào? Độ phức tạp là bao nhiêu?
2. Một đồng nghiệp in ra một `PriorityQueue` để "hiển thị lịch chạy theo thứ tự". Họ sẽ thấy gì, và nên in ra như thế nào?
3. Cài đặt một job scheduler đơn giản: mỗi job có thời điểm `runAt`; một vòng lặp luôn chạy job sớm nhất tiếp theo. Dùng cấu trúc nào, và chi phí thêm một job là bao nhiêu? Huỷ một job theo id thì sao?
4. Gộp K list đã sắp xếp với tổng kích thước N bằng một heap. Nêu độ phức tạp.
