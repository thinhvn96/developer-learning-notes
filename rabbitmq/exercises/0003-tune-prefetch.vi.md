# Bài tập 0003: tinh chỉnh prefetch

Bài tập đi kèm [bài 3](../lessons/0003-acks-prefetch-redelivery.vi.html). · [English](0003-tune-prefetch.md)

Có hai worker: một worker xử lý mỗi job mất 10 ms, worker kia mất 1000 ms. Giải thích chuyện gì xảy ra với worker chậm khi prefetch là 100 so với prefetch là 1. Cách nào chia việc công bằng hơn, cách nào cho throughput tốt hơn? Trích dẫn trang confirms cho khoảng giá trị được khuyến nghị và giải thích vì sao khoảng đó có thể không hợp với các job có thời gian xử lý chênh lệch nhau.
