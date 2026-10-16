# Bài tập 0006: hai session

Đi kèm [bài 6](../lessons/0006-mvcc-and-isolation-levels.vi.html) · [English](0006-two-sessions.md)

1. Chạy `./06-isolation.sh`. Đọc script và giải thích từng dòng output.
2. Thêm biến thể thứ ba với `SERIALIZABLE`, trong đó session A và B mỗi bên đọc dòng của bên kia rồi mới ghi, và xem bên nào nhận serialization failure. (Gợi ý: hai tài khoản, mỗi transaction đọc tổng rồi update dòng của chính nó.)
3. Code của ứng dụng cần làm gì khi gặp lỗi đó?
