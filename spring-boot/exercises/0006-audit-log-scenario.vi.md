# Bài tập 0006: tình huống audit log

Đi kèm [bài 6](../lessons/0006-transaction-propagation.vi.html) · [English](0006-audit-log-scenario.md)

`placeOrder()` phải lưu được bản ghi audit kể cả khi đặt hàng thất bại. Method audit nên dùng propagation mode nào? Method audit phải nằm ở đâu để proxy có tác dụng? Lúc cao điểm, một request giữ bao nhiêu DB connection, và điều đó ảnh hưởng gì tới kích thước pool?
