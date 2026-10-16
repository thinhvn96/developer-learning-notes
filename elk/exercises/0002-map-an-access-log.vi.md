# Bài tập 0002: viết mapping cho access log

Bài tập đi kèm [bài 2](../lessons/0002-documents-indices-and-mappings.vi.html). · [English](0002-map-an-access-log.md)

Viết một explicit mapping cho access log (`@timestamp`, `client_ip`, `method`, `path`, `status`, `duration_ms`, `user_agent`). Với mỗi field, chọn một kiểu và giải thích lý do. Field nào là `keyword`, field nào là `text`? Chạy thử trên Elasticsearch dùng xong bỏ.
