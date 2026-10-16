# Bài tập 0005

Đi kèm [bài 5](../lessons/0005-bulkhead.vi.html). · [English](0005-size-the-bulkheads.md)

Từ một service có 40 thread, bạn gọi payments (chậm, quan trọng), search (nhanh, không bắt buộc) và email (chậm, không bắt buộc). Hãy phân bổ pool và giới hạn semaphore, rồi bảo vệ các con số đó.
