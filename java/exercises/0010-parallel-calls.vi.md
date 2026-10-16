# Bài tập 0010: gọi song song có timeout

Đi kèm [bài 10](../lessons/0010-completablefuture.vi.html). · [English](0010-parallel-calls.md)

Giả lập ba service chậm (sleep 300, 500, 800 ms). Gọi chúng bằng `supplyAsync`, gộp lại bằng `allOf`, và đo tổng thời gian (dự đoán trước). Sau đó cho một service ném exception; trả về giá trị dự phòng bằng `exceptionally`. Cuối cùng chạy lại cùng ba lời gọi đó trên `Executors.newFixedThreadPool(2)`: điều gì thay đổi? Thêm `orTimeout` trên JDK 9+ và giải thích vì sao bài tập chỉ còn khớp với mốc JDK 8 cho tới trước bước đó.
