# Bài tập 0008

Đi kèm [bài 8](../lessons/0008-externalized-configuration-and-profiles.vi.html) · [English](0008-override-in-docker.md)

Build demo app thành jar và image. Khởi động nó với `-e APP_GREETING=from-env`, rồi khởi động lại với `--app.greeting=from-args`. Đoán xem nếu đặt cả hai thì cái nào thắng, rồi kiểm tra lại với danh sách thứ tự ưu tiên.
