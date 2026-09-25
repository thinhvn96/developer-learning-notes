# Exercise 0009: the diamond of defaults

Companion to [lesson 9](../lessons/0009-default-methods-and-conflicts.html).

Create interfaces `A` and `B` (both with `default String hi()`), `C extends A` that redeclares `hi()` as abstract, and classes that implement combinations. Predict compile success or the output first: (1) `class X implements A, B`; (2) `class Y extends Base implements A` where `Base` has `hi()`; (3) `class Z implements C`.
