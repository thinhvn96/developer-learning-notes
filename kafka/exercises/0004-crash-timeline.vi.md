# Bài tập 0004: dòng thời gian khi crash

[English](0004-crash-timeline.md)

Bài tập đi kèm [bài 4](../lessons/0004-delivery-semantics.vi.html).

Vẽ dòng thời gian cho một consumer làm lần lượt: poll một record, ghi vào database, commit offset. Chèn một lần crash vào từng khoảng trống trong ba khoảng giữa các bước. Với mỗi trường hợp, hãy nói consumer kế tiếp sẽ thấy gì và kết quả là đảm bảo delivery nào. Sau đó thiết kế lại bước 2 cho idempotent.
