# Bài tập 0013: hiện đại hóa chuỗi ép kiểu

Đi kèm [bài 13](../lessons/0013-switch-expressions-and-instanceof-patterns.vi.html). · [English](0013-modernize-a-visitor.md)

Hiện đại hóa đoạn code sau:
```java
static String label(Object o) {
    if (o instanceof Integer) { Integer i = (Integer) o; return "int " + (i + 1); }
    else if (o instanceof String) { String s = (String) o; return "str " + s.trim(); }
    return "other";
}
```
bằng `instanceof` pattern (JDK 17). Sau đó viết lại `int daysIn(String month)` thành một switch expression. Cuối cùng, cho biết phiên bản JDK 21 của `label` sẽ trông như thế nào và vì sao nó cần compiler JDK 21.
