# Bài tập 0006: thiết kế một consumer idempotent

[English](0006-design-an-idempotent-consumer.md)

Bài tập đi kèm [bài 6](../lessons/0006-idempotence-and-transactions.vi.html).

Một event `OrderPaid` kích hoạt việc gửi email và trừ tồn kho. Hãy thiết kế consumer sao cho việc giao lại message không thể gửi hai email hay trừ kho hai lần. Bạn lưu các event id đã xử lý ở đâu, và bên trong transaction nào (xem [các bài PostgreSQL](../../postgresql/index.vi.html))?
