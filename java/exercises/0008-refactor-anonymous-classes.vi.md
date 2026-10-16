# Bài tập 0008: thay thế anonymous class

Đi kèm [bài 8](../lessons/0008-lambdas-and-functional-interfaces.vi.html). · [English](0008-refactor-anonymous-classes.md)

1. Viết lại `Collections.sort(list, new Comparator<String>() {...})` bằng một lambda, rồi bằng method reference / `Comparator.comparing`.
2. Viết một lambda tăng một biến local `int count` bên trong `forEach`. Bạn gặp lỗi gì và vì sao? Sửa theo hai cách (dùng một mảng làm chỗ chứa là một cách; hãy nêu cách tốt hơn).
3. Chọn đúng interface trong `java.util.function` cho: "đơn hàng này đã thanh toán chưa?", "in ra một đơn hàng", "từ đơn hàng ra tổng tiền", "tạo một đơn hàng rỗng mới".
