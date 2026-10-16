# Exercise 0015: an expression evaluator

[Tiếng Việt](0015-expression-evaluator.vi.md)

Companion to [lesson 15](../lessons/0015-pattern-matching-switch-and-record-patterns.html).

Model `Expr` as a sealed interface of `Num(int)`, `Add(Expr,Expr)`, `Mul(Expr,Expr)`, `Neg(Expr)`. Write `eval` with a pattern switch and no `default`. Then add `Div` and observe the compiler. Add a guard that simplifies `Mul(Num(0), x)`. Which case order do you need to avoid a dominance error?
