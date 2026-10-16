# Bài tập 0006: parse một dòng log Java

Bài tập đi kèm [bài 6](../lessons/0006-logstash-grok-and-persistent-queues.vi.html). · [English](0006-parse-a-java-stack-trace.md)

Viết một grok pattern cho `2026-09-24 10:15:03.123 ERROR [http-nio-8080-exec-1] c.e.OrderService - Payment failed` và test nó bằng `02-logstash-grok.sh`. Vì sao một stack trace nhiều dòng lại làm hỏng pipeline xử lý theo từng dòng, và codec hay cấu hình Beats nào giải quyết được việc đó? (Tìm trong tài liệu.)
