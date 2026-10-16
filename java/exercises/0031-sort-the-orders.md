# Exercise 0031: Sort the orders

[Tiếng Việt](0031-sort-the-orders.vi.md)

Companion to [lesson 31](../lessons/0031-comparable-comparator-and-ordering.html).

`record Order(String customer, BigDecimal total, LocalDate date, String id) {}`

1. Write one `Comparator<Order>`: newest date first, then biggest total first, then id ascending.
2. Someone stores orders in `new TreeSet<>(Comparator.comparing(Order::date))`. On a day with 300 orders, how many survive? Fix it.
3. Totals `10.0` and `10.00` both appear. Do they count as one key in `TreeMap<BigDecimal, ...>`? In `HashMap<BigDecimal, ...>`? How would you normalize them?
4. Find the bug: `Comparator<Order> c = (a, b) -> (int) (a.date().toEpochDay() - b.date().toEpochDay());` Is it a real risk for dates? For `long` ids?
