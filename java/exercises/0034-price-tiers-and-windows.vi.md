# Bài tập 0034: Bậc giá và khung thời gian

[English](0034-price-tiers-and-windows.md)

Đi kèm [bài 34](../lessons/0034-treemap-and-navigable-maps.vi.html).

1. Biểu thuế: 0% cho đến 11 triệu, 5% từ 11 triệu, 10% từ 25 triệu, 20% từ 50 triệu. Lưu chúng trong một `TreeMap` và viết `rateFor(long income)` chỉ trong một dòng.
2. Một hệ thống đặt phòng họp lưu các lượt đặt dưới dạng `TreeMap<LocalTime, LocalTime>` (giờ bắt đầu tới giờ kết thúc). Dùng `floorEntry` và `ceilingEntry`, viết `boolean canBook(LocalTime start, LocalTime end)`.
3. Trả về tất cả log entry từ 10:00 đến 10:15 trong một `TreeMap<Instant, String>`. Đầu cuối nên là bao gồm hay loại trừ? Kết quả của bạn thay đổi thế nào khi có một entry mới được thêm vào lúc 10:05?
4. Khi nào bạn sẽ chọn `ConcurrentSkipListMap` thay thế? Nó không cho phép điều gì mà `TreeMap` dùng comparator có thể cho phép?
