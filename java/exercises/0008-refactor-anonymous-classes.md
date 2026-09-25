# Exercise 0008: replace anonymous classes

Companion to [lesson 8](../lessons/0008-lambdas-and-functional-interfaces.html).

1. Rewrite `Collections.sort(list, new Comparator<String>() {...})` using a lambda, then a method reference / `Comparator.comparing`.
2. Write a lambda that increments a local `int count` inside `forEach`. What error do you get and why? Fix it two ways (an array holder is one; name the better one).
3. Pick the right `java.util.function` interface for: "is this order paid?", "print an order", "order to total price", "make a new empty order".
