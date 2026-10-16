# Bài tập 0022: Khoá chặt một cluster

[English](0022-lock-down-a-cluster.md)

Bài tập đi kèm [bài 22](../lessons/0022-security-and-quotas.vi.html).

Một cluster dùng chung phục vụ ba team: payments, analytics và notifications. Hiện tại mọi thứ đều dùng `PLAINTEXT` và không có authorizer.

1. Chọn security protocol cho listener và cơ chế SASL, và giải thích vì sao không dùng `PLAIN` qua `SASL_PLAINTEXT`.
2. Viết các lệnh `kafka-acls.sh` sao cho `payments-service` có thể produce vào `payments.*` và consumer group của analytics chỉ được đọc `payments.events`.
3. Chuyện gì xảy ra với mọi client ngay khi bạn bật `StandardAuthorizer` mà chưa có ACL nào? Bạn rollout nó an toàn bằng cách nào?
4. Batch job của team analytics làm bão hoà broker mỗi đêm. Viết lệnh đặt quota và cho biết bạn sẽ gắn nó vào entity nào.
