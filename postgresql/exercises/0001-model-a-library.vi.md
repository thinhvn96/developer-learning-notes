# Bài tập 0001: mô hình hóa một thư viện

Đi kèm [bài 1](../lessons/0001-tables-and-constraints.vi.html) · [English](0001-model-a-library.md)

Thiết kế các table `authors`, `books`, `members`, `loans`. Yêu cầu: ISBN là duy nhất; mỗi member có một email; một lượt mượn (loan) không được tham chiếu tới cuốn sách hay member không tồn tại; không được xóa một cuốn sách khi vẫn còn lượt mượn của nó; ngày trả của một lượt mượn không được sớm hơn ngày mượn.

Viết DDL, sau đó viết năm câu insert cố tình sai, mỗi câu vi phạm một loại constraint, và chạy chúng bằng `./run.sh`. Hãy đoán trước thông báo lỗi của từng câu.
