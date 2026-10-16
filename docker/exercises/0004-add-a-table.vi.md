# Bài tập 0004: tạo table khi khởi động

Đi kèm [bài 4](../lessons/0004-compose-app-and-database.vi.html) · [English](0004-add-a-table.md)

1. Chạy ví dụ Compose, sau đó đổi command của client thành `create table t(id int); insert into t values (1); select * from t;` (dùng mỗi câu lệnh một `psql -c`, hoặc dùng `-f`).
2. Bỏ `depends_on`. Chạy vài lần: client có lúc nào bị lỗi không? Điều đó nói gì về sự khác nhau giữa container đã start và container đã sẵn sàng (readiness)?
3. Chạy `docker compose down` (không có `-v`) rồi `up` lại khi database đã có một table. Dữ liệu còn không? Sau đó dùng `down -v` và kiểm tra lại. Giải thích sự khác biệt dựa trên volume.
