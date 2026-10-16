# Bài tập 0001: phá vỡ thứ tự ghi

Đi kèm [bài 1](../lessons/0001-cache-aside.vi.html). · [English](0001-break-the-write-order.md)

Trong `CacheAsideDemo.java`, hãy đổi chỗ hai dòng trong `write` (invalidate trước, rồi mới cập nhật store). Thiết kế một kịch bản xen kẽ giữa hai thread khiến cache còn lại một giá trị cũ, và mô tả từng bước. Sau đó thêm TTL cho cache (mỗi entry có một timestamp) và chỉ ra TTL giới hạn độ cũ của dữ liệu như thế nào.
