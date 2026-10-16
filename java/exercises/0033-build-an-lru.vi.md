# Bài tập 0033: Viết một LRU cache

[English](0033-build-an-lru.md)

Đi kèm [bài 33](../lessons/0033-hashset-linkedhashmap-and-lru.vi.html).

1. Mở rộng `LruCache` để nó đếm thêm số lần hit và miss. Những lời gọi method nào của `LinkedHashMap` được tính là một lần "truy cập" (access)?
2. Hai thread xử lý request dùng chung một `LruCache`. Giải thích vì sao ngay cả `get` cũng cần đồng bộ hóa ở chế độ access order, và bọc nó lại cho đúng.
3. Không dùng `LinkedHashMap`, hãy thiết kế một LRU cache bằng một `HashMap` cộng với danh sách liên kết đôi tự viết. Chi phí của get và put là bao nhiêu?
4. Một đồng nghiệp in một `HashSet` trong test rồi assert chuỗi kết quả. Test chạy qua ở máy local nhưng fail trên CI. Giải thích dựa vào Javadoc.
