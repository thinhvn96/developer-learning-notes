# Bài tập 0002: thiết kế topology

Bài tập đi kèm [bài 2](../lessons/0002-exchange-types.vi.html). · [English](0002-design-the-topology.md)

Thiết kế exchange, queue và binding cho yêu cầu sau: (a) mọi event về order đều vào một audit queue; (b) order ở EU còn phải vào thêm một queue fulfilment của EU; (c) chỉ các event `payment.failed` mới vào queue của bộ phận support. Nêu rõ kiểu exchange cho từng trường hợp và các binding key. Sửa script ví dụ để dựng topology này và chứng minh routing bằng `routed:true/false`.
