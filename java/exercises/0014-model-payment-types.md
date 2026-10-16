# Exercise 0014: model payment types

[Tiếng Việt](0014-model-payment-types.vi.md)

Companion to [lesson 14](../lessons/0014-sealed-classes.html).

Model `Payment` as a sealed interface with `Card(String last4)`, `BankTransfer(String iban)` and `Wallet(String provider)` records. Write `fee(Payment p)` with `instanceof` patterns on JDK 17. Add a fourth variant: which code no longer compiles or silently misses it? Compare with an `enum` + fields design.
