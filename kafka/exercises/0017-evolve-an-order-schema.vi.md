# Bài tập 0017: Tiến hoá schema của order

[English](0017-evolve-an-order-schema.md)

Bài tập đi kèm [bài 17](../lessons/0017-schemas-and-schema-registry.vi.html).

Schema Avro ban đầu `Order { string id; long amountCents; }`, subject `orders-value`, compatibility `BACKWARD`.

Với mỗi thay đổi, hãy cho biết registry có chấp nhận không và bạn deploy bên nào trước:
1. Thêm `string currency` với mặc định `"VND"`.
2. Thêm `string customerId` không có mặc định.
3. Xoá `amountCents`.
4. Đổi tên `id` thành `orderId`.

Sau đó: topic này là compacted và các service mới sẽ replay nó từ đầu. Bạn có đổi chế độ tương thích không? Đổi sang gì, và vì sao?
