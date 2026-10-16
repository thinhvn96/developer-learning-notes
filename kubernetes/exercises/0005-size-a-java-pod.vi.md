# Bài tập 0005: định cỡ cho một Pod Java

Đi kèm [bài 5](../lessons/0005-requests-limits-and-the-jvm.vi.html) · [English](0005-size-a-java-pod.md)

Service của bạn dùng khoảng 300 MB heap và 100 MB non-heap ở trạng thái ổn định, và có lúc vọt lên 380 MB heap.
1. Chọn memory request, memory limit và `MaxRAMPercentage`. Trình bày cách tính.
2. Lựa chọn nào của bạn sẽ gây OOM kill, lựa chọn nào sẽ gây throttling?
3. Bảo vệ quan điểm request = limit so với request < limit cho memory trong hai câu.
