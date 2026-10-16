# Exercise 0036: Choose the special map

[Tiếng Việt](0036-choose-the-special-map.vi.md)

Companion to [lesson 36](../lessons/0036-enummap-identity-and-weak-maps.html).

Choose `EnumMap`, `EnumSet`, `IdentityHashMap`, `WeakHashMap` or "none of these" and justify:

1. User permissions from `enum Permission { READ, WRITE, DELETE, ADMIN }`.
2. Count of orders per `OrderStatus`.
3. A deep-copy utility that must copy an object graph with cycles.
4. A cache of 10,000 product images, evicting the least recently used.
5. Extra debug info attached to `Thread` objects you do not own, which must not keep dead threads in memory.

Then explain the bug: `WeakHashMap<String, Session>` where each `Session` holds its own id string.
