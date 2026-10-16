# Bài tập 0007: không để mất log nào

Bài tập đi kèm [bài 7](../lessons/0007-filebeat-delivery-and-backpressure.vi.html). · [English](0007-lose-no-logs.md)

Liệt kê các kịch bản sự cố (Filebeat restart, Logstash crash, Elasticsearch sập, đầy đĩa, log rotation) và với từng kịch bản, ghi lại tài liệu nói chuyện gì sẽ xảy ra, và hệ quả là bị trùng hay bị hụt dữ liệu ra sao. Thiết kế cơ chế khử trùng lặp (deduplication) bằng document id.
