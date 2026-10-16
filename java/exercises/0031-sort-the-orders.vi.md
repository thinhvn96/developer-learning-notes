# Bài tập 0031: Sắp xếp các đơn hàng

[English](0031-sort-the-orders.md)

Đi kèm [bài 31](../lessons/0031-comparable-comparator-and-ordering.vi.html).

`record Order(String customer, BigDecimal total, LocalDate date, String id) {}`

1. Viết một `Comparator<Order>`: ngày mới nhất trước, sau đó tổng tiền lớn nhất trước, sau đó id tăng dần.
2. Có người lưu các đơn hàng trong `new TreeSet<>(Comparator.comparing(Order::date))`. Vào một ngày có 300 đơn, còn lại bao nhiêu đơn? Sửa lại.
3. Cả hai giá trị tổng `10.0` và `10.00` đều xuất hiện. Chúng có được tính là một key trong `TreeMap<BigDecimal, ...>` không? Trong `HashMap<BigDecimal, ...>` thì sao? Bạn sẽ chuẩn hóa chúng thế nào?
4. Tìm bug: `Comparator<Order> c = (a, b) -> (int) (a.date().toEpochDay() - b.date().toEpochDay());` Đây có phải rủi ro thật với ngày tháng không? Với id kiểu `long` thì sao?
