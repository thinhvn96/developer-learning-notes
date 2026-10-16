# Bài tập 0002: join ba table

Đi kèm [bài 2](../lessons/0002-joins-inner-and-left.vi.html) · [English](0002-three-way-join.md)

Dùng schema thư viện của bạn, liệt kê mọi member kèm số lượt mượn của họ, kể cả những member chưa từng mượn. Sau đó:
1. Bạn cần loại join nào, và tại sao?
2. Thêm `WHERE` với điều kiện `loans.returned_on IS NULL` và quan sát. Chuyện gì đã xảy ra với những member không có lượt mượn nào?
3. Sửa lại bằng cách chuyển điều kiện đó vào `ON`.
