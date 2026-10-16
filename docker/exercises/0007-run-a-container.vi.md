# Bài tập 0007

Đi kèm [bài 7](../lessons/0007-run-flags-and-container-lifecycle.vi.html) · [English](0007-run-a-container.md)

Chạy `nginx:alpine` với `-d -p 127.0.0.1::80 --name web`, tìm port đã publish bằng `docker port`, `curl` vào port đó, xem `docker logs web`, chạy `docker exec -it web sh`, rồi stop và xóa container. Trong các bước trên, bước nào đã xóa dữ liệu của container?
