# Bài tập 0036: Chọn map chuyên dụng

[English](0036-choose-the-special-map.md)

Đi kèm [bài 36](../lessons/0036-enummap-identity-and-weak-maps.vi.html).

Chọn `EnumMap`, `EnumSet`, `IdentityHashMap`, `WeakHashMap` hoặc "không cái nào" và giải thích lý do:

1. Quyền của user lấy từ `enum Permission { READ, WRITE, DELETE, ADMIN }`.
2. Số lượng order theo từng `OrderStatus`.
3. Một tiện ích deep copy phải copy được một đồ thị object có vòng lặp.
4. Một cache gồm 10.000 ảnh sản phẩm, loại bỏ ảnh ít được dùng gần đây nhất.
5. Thông tin debug bổ sung gắn vào các object `Thread` không thuộc quyền quản lý của bạn, và không được giữ các thread đã chết trong bộ nhớ.

Sau đó giải thích bug: `WeakHashMap<String, Session>` trong đó mỗi `Session` giữ chính chuỗi id của nó.
