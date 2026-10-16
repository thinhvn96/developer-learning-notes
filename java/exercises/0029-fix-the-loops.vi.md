# Bài tập 0029: Sửa các vòng lặp

[English](0029-fix-the-loops.md)

Đi kèm [bài 29](../lessons/0029-iterators-and-fail-fast.vi.html).

Mỗi đoạn code dưới đây đều có bug. Hãy dự đoán chuyện gì xảy ra (exception, kết quả sai, hay chạy đúng nhờ may mắn), rồi sửa nó theo hai cách.

```java
// A
for (Order o : orders) if (o.isCancelled()) orders.remove(o);

// B
for (String key : prices.keySet()) if (prices.get(key) == 0) prices.remove(key);

// C
for (int i = 0; i < ids.size(); i++) if (ids.get(i) < 0) ids.remove(i);
```

1. Vì sao C không ném exception, và nó có thể bỏ sót phần tử nào?
2. Viết một list 3 phần tử mà với nó A chạy xong không có exception. Vì sao như vậy còn tệ hơn có exception?
3. Một đồng nghiệp bọc A trong `try { ... } catch (ConcurrentModificationException e) {}`. Trích câu trong Javadoc giải thích vì sao làm vậy là sai.
