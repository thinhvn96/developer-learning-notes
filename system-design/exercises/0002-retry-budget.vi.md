# Bài tập 0002: retry budget

Đi kèm [bài 2](../lessons/0002-retries-and-idempotency.vi.html). · [English](0002-retry-budget.md)

Service A gọi B, B gọi C; mỗi tầng retry 3 lần. Nếu C sập, C nhận bao nhiêu lời gọi cho mỗi request tới A? Lời khuyên của tài liệu về việc chỉ retry ở một tầng thay đổi điều gì? Sau đó sửa `RetryDemo` để dừng theo một ngân sách tổng thời gian (time budget) thay vì theo số lần thử.
