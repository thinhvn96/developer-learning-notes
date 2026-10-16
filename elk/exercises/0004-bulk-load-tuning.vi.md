# Bài tập 0004: tinh chỉnh bulk load

Bài tập đi kèm [bài 4](../lessons/0004-near-real-time-search-and-refresh.vi.html). · [English](0004-bulk-load-tuning.md)

Trên cluster dùng xong bỏ, index 100.000 document bằng API `_bulk`. So sánh thời gian khi `refresh_interval` là `1s` và `-1`, rồi refresh thủ công ở cuối. Giải thích sự khác biệt dựa trên trang near real-time.
