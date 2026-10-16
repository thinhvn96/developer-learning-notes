# Bài tập 0003: record làm key của map

Đi kèm [bài 3](../lessons/0003-records-and-immutability.vi.html) và [bài 1](../lessons/0001-hashmap-equals-hashcode.vi.html). · [English](0003-record-as-key.md)

1. Viết `record Coord(int row, int col)`. Đưa `new Coord(1, 2)` vào một `HashMap<Coord,String>`, rồi tra cứu bằng một `new Coord(1, 2)` khác. Dự đoán kết quả trước.
2. Đổi một component thành `List<Integer> path`. Đưa một entry vào, sửa list đó, rồi tra cứu lại. Chuyện gì xảy ra, và vì sao bài 1 giải thích được điều đó?
3. Sửa lỗi bằng compact constructor. Cách sửa này có bảo vệ được cả trường hợp caller vẫn giữ reference tới list gốc không?
