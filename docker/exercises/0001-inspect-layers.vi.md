# Bài tập 0001: xem các layer

Đi kèm [bài 1](../lessons/0001-containers-images-layers.vi.html) · [English](0001-inspect-layers.md)

1. Chạy `docker pull eclipse-temurin:21-jre` rồi `docker history eclipse-temurin:21-jre`. Có bao nhiêu layer? Layer nào lớn nhất?
2. Chạy `docker run --rm -it eclipse-temurin:21-jre bash`, tạo một file, rồi thoát. Chạy lại lần nữa. File đó còn không? Giải thích bằng hai khái niệm "image bất biến" và "container".
3. So sánh kết quả `uname -r` trên máy host và bên trong container. Điều đó cho bạn biết gì về kernel?
