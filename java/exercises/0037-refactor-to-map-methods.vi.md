# Bài tập 0037: Refactor sang các method của Map

[English](0037-refactor-to-map-methods.md)

Đi kèm [bài 37](../lessons/0037-map-default-methods.vi.html).

Viết lại mỗi đoạn dưới đây bằng một lần gọi method của `Map`:

```java
// A
List<Order> list = byCustomer.get(c);
if (list == null) { list = new ArrayList<>(); byCustomer.put(c, list); }
list.add(order);

// B
Integer n = counts.get(word);
counts.put(word, n == null ? 1 : n + 1);

// C
if (stock.containsKey(sku)) {
    int left = stock.get(sku) - qty;
    if (left <= 0) stock.remove(sku); else stock.put(sku, left);
}
```

Sau đó:
1. Vì sao `cache.putIfAbsent(key, loadFromDatabase(key))` lãng phí? Hãy viết lại.
2. Hàm đệ quy có memoization của bạn ném `ConcurrentModificationException`. Vì sao, và cách sửa là gì?
3. Trên một `ConcurrentHashMap`, đoạn nào trong A, B và C hết race condition sau khi bạn viết lại?
