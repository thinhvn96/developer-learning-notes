# Bài tập 0001: lần theo một message

Bài tập đi kèm [bài 1](../lessons/0001-amqp-model-exchanges-queues-bindings.vi.html). · [English](0001-trace-a-message.md)

Chạy `./01-routing-ack-dlx.sh` và với mỗi dòng publish, ghi ra: exchange, routing key, các binding khớp, các queue nhận được bản sao. Sau đó giải thích điều gì sẽ thay đổi nếu publisher dùng default exchange với routing key là tên queue.
