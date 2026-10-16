# Bài tập 0001: partition và key

[English](0001-partitions-and-keys.md)

Bài tập đi kèm [bài 1](../lessons/0001-events-topics-partitions.vi.html).

1. Chạy `./01-topics-keys-groups.sh`. Mỗi key rơi vào partition nào?
2. Đổi topic thành 1 partition rồi chạy lại. Thứ tự giữa các key khác nhau thay đổi thế nào?
3. Giải thích vì sao bạn nên dùng `userId` làm key cho event của user, chứ không dùng một UUID ngẫu nhiên.
4. Điều gì xảy ra với đảm bảo thứ tự nếu sau này bạn tăng số partition của một topic đang chứa dữ liệu có key? Hãy tìm câu trả lời trong tài liệu; nói rõ chỗ nào bạn không tìm được.
