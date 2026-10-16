# Exercise 0022: Lock down a cluster

[Tiếng Việt](0022-lock-down-a-cluster.vi.md)

Companion to [lesson 22](../lessons/0022-security-and-quotas.html).

A shared cluster hosts three teams: payments, analytics and notifications. Today everything uses `PLAINTEXT` with no authorizer.

1. Choose listener security protocol and SASL mechanism, and explain why not `PLAIN` over `SASL_PLAINTEXT`.
2. Write the `kafka-acls.sh` commands so `payments-service` can produce to `payments.*` and the analytics consumer group can only read `payments.events`.
3. What happens to every client the moment you enable `StandardAuthorizer` without any ACLs? How do you roll it out safely?
4. The analytics team's batch job saturates the brokers every night. Write the quota command and say which entity you would attach it to.
