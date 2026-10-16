# Bài tập 0010

Đi kèm [bài 10](../lessons/0010-volumes-and-bind-mounts.vi.html) · [English](0010-persist-postgres.md)

Chạy `postgres:18` với một named volume mount vào `/var/lib/postgresql`, tạo một table, xóa container, start một container mới dùng lại volume đó, rồi kiểm tra table. Sau đó làm lại mà không dùng volume.
