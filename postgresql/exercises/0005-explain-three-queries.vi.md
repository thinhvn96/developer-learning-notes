# Bài tập 0005: EXPLAIN ba query

Đi kèm [bài 5](../lessons/0005-reading-explain.vi.html) · [English](0005-explain-three-queries.md)

Với từng query dưới đây trên các table của bài tập 0004, chạy `EXPLAIN ANALYZE` và kể lại "câu chuyện" của plan trong hai câu: (a) tìm theo primary key; (b) lọc theo một cột không có index; (c) một join có kèm hàm tổng hợp.

Sau đó chạy `EXPLAIN ANALYZE` trên một table vừa nạp dữ liệu mà chưa chạy `ANALYZE`, rồi chạy `ANALYZE`, và so sánh số dòng ước tính với số dòng thực tế.
