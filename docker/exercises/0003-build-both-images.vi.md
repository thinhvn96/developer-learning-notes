# Bài tập 0003: build cả hai image

Đi kèm [bài 3](../lessons/0003-multi-stage-java-image.vi.html) · [English](0003-build-both-images.md)

1. Trong `docker/examples/hello-java`, build `Dockerfile.naive` thành `hello-naive` và `Dockerfile` thành `hello-multi`.
2. So sánh kích thước bằng `docker images`. Ghi lại cả hai con số.
3. Dùng `docker build --target build -t hello-build .` rồi xem bên trong kết quả. Trong đó có gì mà image cuối cùng không có?
4. Nâng cao: tìm một base image JRE nhỏ hơn và đo kích thước. Ghi rõ bạn tìm thấy nó ở đâu.
