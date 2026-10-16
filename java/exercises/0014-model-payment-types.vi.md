# Bài tập 0014: mô hình hóa các loại thanh toán

Đi kèm [bài 14](../lessons/0014-sealed-classes.vi.html). · [English](0014-model-payment-types.md)

Mô hình hóa `Payment` thành một sealed interface với các record `Card(String last4)`, `BankTransfer(String iban)` và `Wallet(String provider)`. Viết `fee(Payment p)` bằng `instanceof` pattern trên JDK 17. Thêm một biến thể thứ tư: đoạn code nào không còn biên dịch được, hoặc âm thầm bỏ sót nó? So sánh với thiết kế dùng `enum` + field.
