# Bài tập 0001: Cái key đã bị thay đổi

Đi kèm [bài 0001](../lessons/0001-hashmap-equals-hashcode.vi.html). Viết một class `MutableKey` có field `id` không final, cùng `equals` và `hashCode` đúng, dựa trên `id`. · [English](0001-mutable-key.md)

1. Đưa một `MutableKey("a")` vào một `HashMap`, giữ lại reference tới key đó.
2. Gọi `key.id = "b"`.
3. Dự đoán, rồi kiểm tra: `map.get(key)`, `map.containsKey(key)` và `map.size()` trả về gì? Có cách nào lấy lại entry đó mà không phải duyệt qua map không?
4. Viết hai câu bạn có thể nói trong interview để giải thích vì sao nên dùng key immutable (`String`, `Integer`, record).

Nâng cao: đọc đoạn "Note: great care must be exercised if mutable objects are used as map keys" (Lưu ý: phải hết sức cẩn thận nếu dùng object mutable làm key của map) trong [Javadoc của `Map`](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.html) và so sánh với câu trả lời của bạn.

Hãy nói dự đoán của bạn cho giáo viên *trước khi* chạy code.
