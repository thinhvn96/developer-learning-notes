# Bài tập 0018: Xây một window phát hiện gian lận

[English](0018-fraud-window.md)

Bài tập đi kèm [bài 18](../lessons/0018-streams-windows-joins-exactly-once.vi.html).

Yêu cầu: đánh dấu một thẻ nếu nó thực hiện hơn 5 giao dịch thanh toán trong bất kỳ khoảng 1 phút nào. Giao dịch có thể đến muộn tối đa 20 giây.

1. Tumbling, hopping, sliding hay session window: loại nào khớp với "bất kỳ khoảng 1 phút nào", và vì sao tumbling window bỏ sót một số trường hợp?
2. Viết code DSL (key, windowing có grace, count, filter, output topic).
3. Bạn muốn làm giàu dữ liệu cho mỗi thẻ bị đánh dấu bằng hạng rủi ro của khách hàng lấy từ topic `customers` (2 triệu dòng, 6 partition). Topic `payments` có 24 partition. Bạn dùng loại join nào, và nếu dùng join với `KTable` thì cái gì sẽ hỏng?
4. Ở đây bạn có cần `exactly_once_v2` không? Thiếu nó thì chuyện gì có thể xảy ra ở phía downstream?
