# Bài tập 0006: gia cố một Dockerfile

Đi kèm [bài 6](../lessons/0006-pinning-nonroot-and-signals.vi.html) · [English](0006-harden-a-dockerfile.md)

1. Tra digest của `eclipse-temurin:21-jre` (`docker buildx imagetools inspect eclipse-temurin:21-jre`) và pin nó trong `hello-java/Dockerfile`.
2. Đổi `CMD ["java", ...]` sang shell form (`CMD java -cp . Hello`). Sửa ứng dụng để nó sleep trong một vòng lặp và in ra một dòng khi nhận `SIGTERM` thông qua shutdown hook; chạy nó, rồi `docker stop`. So sánh exec form và shell form. Ghi lại những gì bạn thực sự quan sát được, không phải những gì bạn đoán trước.
3. Thử ghi một file vào `/` bên trong container với user `app`. Chuyện gì xảy ra và tại sao?
