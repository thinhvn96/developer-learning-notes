# Bài tập 0038: Ước lượng kích thước cache

[English](0038-size-the-cache.md)

Đi kèm [bài 38](../lessons/0038-capacity-boxing-and-memory.vi.html).

1. Một service giữ trong bộ nhớ một `Map<Long, Long>` gồm 20 triệu user id ánh xạ tới timestamp lần cuối hoạt động. Dựa vào số đo trong bài, hãy ước lượng bậc độ lớn của bộ nhớ. Đề xuất hai cách biểu diễn rẻ hơn.
2. Chạy `CapacityAndBoxing.java` ba lần. Số nào ổn định và số nào dao động? Công cụ nào sẽ cho bạn số liệu đáng tin cậy (chỉ cần nêu tên, không cần dùng)?
3. Giải thích kết quả `128 == 128: false` và tìm bug: `if (order.getStatusCode() == response.getStatusCode())` trong đó cả hai đều trả về `Integer`.
4. `List<Integer> ids = new ArrayList<>(List.of(5, 1, 7)); ids.remove(1);` Bây giờ `ids` là gì? Viết dòng code xoá giá trị 1.
