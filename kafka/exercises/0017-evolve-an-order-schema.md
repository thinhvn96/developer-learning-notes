# Exercise 0017: Evolve an order schema

[Tiếng Việt](0017-evolve-an-order-schema.vi.md)

Companion to [lesson 17](../lessons/0017-schemas-and-schema-registry.html).

Starting Avro schema `Order { string id; long amountCents; }`, subject `orders-value`, compatibility `BACKWARD`.

For each change, say whether the registry accepts it and which side you deploy first:
1. Add `string currency` with default `"VND"`.
2. Add `string customerId` with no default.
3. Remove `amountCents`.
4. Rename `id` to `orderId`.

Then: the topic is compacted and new services replay it from the beginning. Would you change the compatibility mode? To what, and why?
