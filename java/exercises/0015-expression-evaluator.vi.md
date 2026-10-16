# Bài tập 0015: bộ tính giá trị biểu thức

Đi kèm [bài 15](../lessons/0015-pattern-matching-switch-and-record-patterns.vi.html). · [English](0015-expression-evaluator.md)

Mô hình hóa `Expr` thành một sealed interface gồm `Num(int)`, `Add(Expr,Expr)`, `Mul(Expr,Expr)`, `Neg(Expr)`. Viết `eval` bằng một pattern switch không có `default`. Sau đó thêm `Div` và quan sát compiler phản ứng thế nào. Thêm một guard để rút gọn `Mul(Num(0), x)`. Bạn cần sắp xếp các case theo thứ tự nào để tránh lỗi dominance?
