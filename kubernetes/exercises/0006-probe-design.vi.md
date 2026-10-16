# Bài tập 0006: thiết kế probe

Đi kèm [bài 6](../lessons/0006-probes.vi.html) · [English](0006-probe-design.md)

Một service Spring Boot mất 45 s để khởi động, có gọi database và một payment API. Thiết kế startup, readiness và liveness probe: path, period, failure threshold. Với mỗi probe, nói rõ cái gì nên kiểm tra và cái gì không nên, và chuyện gì xảy ra nếu payment API bị sập.
