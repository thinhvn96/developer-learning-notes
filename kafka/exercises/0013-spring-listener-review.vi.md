# Bài tập 0013: Review một Spring listener

[English](0013-spring-listener-review.md)

Bài tập đi kèm [bài 13](../lessons/0013-spring-kafka.vi.html).

Hãy review listener này như thể nó là một pull request:

```java
@KafkaListener(topics = "payments", concurrency = "12")
public void onPayment(PaymentEvent e) {
    paymentService.charge(e.accountId(), e.amount());   // calls a card provider
    emailService.sendReceipt(e.accountId());
}
```

Topic có 6 partition, container dùng cấu hình mặc định.

1. Thực sự có bao nhiêu consumer đang làm việc? Số còn lại thì sao?
2. Offset được commit lúc nào (nêu tên AckMode)? Mô tả chính xác chuyện gì xảy ra nếu pod bị kill sau `charge` nhưng trước khi batch xử lý xong.
3. Làm cho việc gửi lại trở nên an toàn: bạn sẽ lưu gì, lưu ở đâu, để `charge` không bị thực hiện hai lần?
4. Bạn có chuyển sang `MANUAL_IMMEDIATE` không? Lập luận cho cả hai phía, mỗi phía hai câu.
