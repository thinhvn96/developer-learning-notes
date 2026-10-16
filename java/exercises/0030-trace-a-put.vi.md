# Bài tập 0030: Lần theo một lệnh put

[English](0030-trace-a-put.md)

Đi kèm [bài 30](../lessons/0030-hashmap-internals.vi.html).

1. Tính bằng tay (rồi kiểm tra bằng một chương trình nhỏ): một `HashMap` với cấu hình mặc định nhận các key `"Aa"`, `"BB"` và `"apple"`. Với mỗi key, tính spread hash và index của bucket. Những key nào nằm chung một bucket?
2. Một `HashMap` mặc định resize lần đầu sau bao nhiêu entry? Lần thứ hai thì sao?
3. Bạn put 1.000.000 entry vào `new HashMap<>()`. Xấp xỉ bao nhiêu lần resize xảy ra? Viết lại dòng khởi tạo cho JDK 8 và cho JDK 21 để không có lần resize nào.
4. Chạy `HashMapInternals.java`. Giải thích chênh lệch 50 lần bằng các từ "bin", "tree" và "Comparable".
5. Luyện interview (90 giây, nói thành tiếng): "Chuyện gì xảy ra khi tôi gọi `map.put(k, v)`?"
