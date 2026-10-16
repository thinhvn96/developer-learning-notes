# Exercise 0013: Review a Spring listener

[Tiếng Việt](0013-spring-listener-review.vi.md)

Companion to [lesson 13](../lessons/0013-spring-kafka.html).

Review this listener as if it were a pull request:

```java
@KafkaListener(topics = "payments", concurrency = "12")
public void onPayment(PaymentEvent e) {
    paymentService.charge(e.accountId(), e.amount());   // calls a card provider
    emailService.sendReceipt(e.accountId());
}
```

The topic has 6 partitions, the container uses default settings.

1. How many consumers are actually busy? What happens to the rest?
2. When is the offset committed (name the AckMode)? Describe exactly what happens if the pod is killed after `charge` but before the batch finishes.
3. Make it safe to redeliver: what would you store, and where, so `charge` is not done twice?
4. Would you switch to `MANUAL_IMMEDIATE`? Argue both sides in two sentences each.
