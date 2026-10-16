# Bài tập 0032: Bảo vệ state

[English](0032-defend-the-state.md)

Đi kèm [bài 32](../lessons/0032-unmodifiable-vs-immutable.vi.html).

```java
public class Cart {
    private final List<Item> items = new ArrayList<>();
    public List<Item> getItems() { return items; }
}
```

1. Chỉ ra hai cách phía gọi có thể làm hỏng `Cart` thông qua `getItems()`.
2. Sửa theo ba cách: `Collections.unmodifiableList(items)`, `List.copyOf(items)`, `new ArrayList<>(items)`. Với mỗi cách, phía gọi thấy gì nếu giỏ hàng thay đổi sau đó, và cái giá phải trả là gì?
3. `Item` có field `quantity` mutable. Cách sửa nào của bạn vẫn bị rò rỉ? Điều gì sẽ làm cho giỏ hàng thực sự immutable?
4. Dự đoán, rồi chạy thử: `Arrays.asList(1, 2, 3).add(4)`, `List.of(1, 2).contains(null)`, `Map.of("a", 1, "a", 2)`.
