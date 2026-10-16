# Bài tập 0021: Queue hay group?

[English](0021-queue-or-group.md)

Bài tập đi kèm [bài 21](../lessons/0021-share-groups.vi.html).

1. Chạy `../examples/08-share-group.sh`. Chạy lại với consumer group (thay share consumer bằng `kafka-console-consumer.sh --group workers`). Cái gì thay đổi?
2. Với mỗi workload, chọn consumer group hay share group và giải thích lý do: (a) resize ảnh được upload; (b) áp các bút toán sổ cái vào số dư tài khoản; (c) gửi push notification; (d) xây search index từ các thay đổi của sản phẩm.
3. Một worker trong share group bị crash khi đang giữ 50 record. Chuyện gì xảy ra với chúng, và mặc định là sau bao lâu?
4. Một record thất bại 5 lần. Tiếp theo sẽ ra sao? So sánh điều đó với DLT trong một thiết kế dùng consumer group.
