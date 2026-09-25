# Exercise 0006: parse a Java log

Companion to [lesson 6](../lessons/0006-logstash-grok-and-persistent-queues.html).

Write a grok pattern for `2026-09-24 10:15:03.123 ERROR [http-nio-8080-exec-1] c.e.OrderService - Payment failed` and test it with `02-logstash-grok.sh`. Why does a multi-line stack trace break a line-by-line pipeline, and which codec or Beats setting addresses it? (Find it in the docs.)
