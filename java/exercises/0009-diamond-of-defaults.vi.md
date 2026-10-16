# Bài tập 0009: hình kim cương của các default

Đi kèm [bài 9](../lessons/0009-default-methods-and-conflicts.vi.html). · [English](0009-diamond-of-defaults.md)

Tạo các interface `A` và `B` (cả hai đều có `default String hi()`), `C extends A` khai báo lại `hi()` thành abstract, và các class cài đặt những tổ hợp khác nhau. Dự đoán trước là biên dịch được hay không, hoặc output là gì: (1) `class X implements A, B`; (2) `class Y extends Base implements A`, trong đó `Base` có `hi()`; (3) `class Z implements C`.
