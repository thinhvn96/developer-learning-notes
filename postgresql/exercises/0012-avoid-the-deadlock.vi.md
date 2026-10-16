# Bài tập 0012

Đi kèm [bài 12](../lessons/0012-row-locks-and-deadlocks.vi.html) · [English](0012-avoid-the-deadlock.md)

Sửa hai session trong `11-locking.sh` để chúng update các dòng theo cùng một thứ tự và xác nhận không còn deadlock. Sau đó giữ nguyên thứ tự ngược nhau nhưng thêm `SELECT ... FOR UPDATE` trên cả hai dòng ngay từ đầu, sắp xếp theo id. Cách nào chắc chắn hơn?
