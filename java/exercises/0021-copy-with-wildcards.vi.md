# Bài tập 0021

Đi kèm [bài 21](../lessons/0021-wildcards-and-type-erasure.vi.html). · [English](0021-copy-with-wildcards.md)

Viết `static <T> void copy(List<? super T> dest, List<? extends T> src)`. Lời gọi nào biên dịch được: `copy(List<Number>, List<Integer>)`, `copy(List<Integer>, List<Number>)`? Giải thích bằng khái niệm producer/consumer.

Nói dự đoán của bạn cho giáo viên trước khi chạy bất cứ thứ gì.
