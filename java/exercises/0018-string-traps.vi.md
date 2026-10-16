# Bài tập 0018

Đi kèm [bài 18](../lessons/0018-strings-immutability-and-stringbuilder.vi.html). · [English](0018-string-traps.md)

Dự đoán, rồi chạy: `"a"+"b" == "ab"`, `new String("ab") == "ab"`, `("a"+x)=="ab"` với `String x="b"`. Giải thích từng trường hợp bằng pool và tính bất biến. Sau đó đo thời gian một vòng lặp 100.000 lần dùng `+=` so với `StringBuilder` (báo cáo số liệu của bạn, đừng dựa vào truyền miệng).

Nói dự đoán của bạn cho giáo viên trước khi chạy bất cứ thứ gì.
