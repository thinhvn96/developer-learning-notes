# Bài tập 0039: Chọn cấu trúc concurrent

[English](0039-pick-the-concurrent-structure.md)

Đi kèm [bài 39](../lessons/0039-concurrent-collections.vi.html).

Với mỗi trường hợp, chọn cấu trúc dữ liệu và chính xác các method sẽ dùng:

1. Các event listener được đăng ký lúc khởi động, được nhiều thread thông báo ở mỗi request.
2. Một bộ đếm request theo từng endpoint, được 200 thread cập nhật.
3. Các mức giá trong một order book, được đọc theo khoảng và cập nhật đồng thời.
4. Một pipeline: 4 thread parse file, 2 thread ghi vào database; việc parse phải chậm lại khi các thread ghi bị tụt lại phía sau.
5. Một list các session đang hoạt động, được một cleanup job duyệt mỗi phút và được các thread xử lý request sửa đổi.

Sau đó: trong lần chạy ở bài học, `ArrayList` thông thường kết thúc với 13.243 phần tử và không có exception nào. Giải thích 26.757 lần add còn lại đã đi đâu.
