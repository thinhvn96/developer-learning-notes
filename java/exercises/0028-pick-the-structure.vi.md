# Bài tập 0028: Chọn cấu trúc dữ liệu

[English](0028-pick-the-structure.md)

Đi kèm [bài 28](../lessons/0028-collections-framework-map.vi.html).

Với mỗi yêu cầu dưới đây, hãy nêu interface bạn sẽ khai báo và implementation bạn sẽ khởi tạo, rồi nói câu hỏi nào trong ba câu (có trùng lặp không? có thứ tự không? có tra cứu theo key không?) đã quyết định lựa chọn đó.

1. 50 lượt xem trang gần nhất của một user, mới nhất đứng đầu.
2. Tất cả tag khác nhau của một blog, in ra theo thứ tự bảng chữ cái.
3. Giá sản phẩm theo SKU, được tra cứu ở mỗi request.
4. Các job đang chờ chạy, luôn lấy job có deadline sớm nhất trước.
5. Thứ tự user thêm sản phẩm vào giỏ hàng, không trùng lặp.
6. Lịch sử của nút Back trên trình duyệt.

Sau đó chạy `java java/examples/collections/FrameworkMap.java` và giải thích vì sao `PriorityQueue` không phải là một `SequencedCollection`.
