# Bài tập 0005: heap dưới giới hạn tài nguyên

Đi kèm [bài 5](../lessons/0005-memory-cpu-limits-and-the-jvm.vi.html) · [English](0005-heap-under-limits.md)

1. Chạy `hello-multi` với `--memory` lần lượt là 128m, 256m, 512m, 1g. Lập bảng max heap. Từ mức nào thì heap không còn xấp xỉ một nửa nữa?
2. Lặp lại với `-e JAVA_TOOL_OPTIONS=-XX:MaxRAMPercentage=75`.
3. Chạy với `--cpus=0.5`. JVM báo có bao nhiêu processor?
4. Chạy với `-e JAVA_TOOL_OPTIONS=-Xlog:os+container=trace` và tìm dòng log mà JVM ghi giới hạn memory.
