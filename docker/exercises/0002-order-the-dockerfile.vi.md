# Bài tập 0002: sắp xếp lại Dockerfile

Đi kèm [bài 2](../lessons/0002-layer-cache-and-dockerfile-order.vi.html) · [English](0002-order-the-dockerfile.md)

1. Trong `docker/examples/hello-java`, chạy `docker build -t h1 .` hai lần. Ở lần build thứ hai, mỗi bước in ra gì?
2. Sửa `src/Hello.java` (đổi câu chào) rồi build lại. Bước nào chạy lại, bước nào lấy từ cache?
3. Viết lại một Dockerfile đang bắt đầu bằng `COPY . .` sao cho bước tải dependency vẫn dùng cache khi chỉ có source thay đổi. Nêu rõ bạn đã di chuyển lệnh nào và tại sao.
