# Bài tập 0006: kế hoạch xử lý poison message

Bài tập đi kèm [bài 6](../lessons/0006-quorum-queues-and-poison-messages.vi.html). · [English](0006-poison-message-plan.md)

Một consumer ném exception với các message có một field bị sai định dạng. Viết kế hoạch end-to-end: kiểu queue, delivery limit, DLX, những gì được lưu kèm dead letter, cảnh báo, và quy trình replay sau khi đã sửa lỗi. Vì sao bản thân consumer vẫn phải idempotent?
