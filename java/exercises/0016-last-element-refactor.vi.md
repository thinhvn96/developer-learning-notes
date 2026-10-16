# Bài tập 0016: refactor cách lấy phần tử cuối

Đi kèm [bài 16](../lessons/0016-sequenced-collections.vi.html). · [English](0016-last-element-refactor.md)

Tìm ba cách viết quen thuộc trong chính code của bạn cho "phần tử cuối" hoặc "thứ tự đảo ngược" (`list.get(list.size() - 1)`, `Collections.reverse`, mẹo duyệt `LinkedHashSet`, `Deque.peekLast`). Viết lại bằng các method sequenced. Cách nào thay đổi hành vi khi collection rỗng (gợi ý: exception)? Kiểm tra Javadoc của `getLast`.
