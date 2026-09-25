# Exercise 0016: last-element refactor

Companion to [lesson 16](../lessons/0016-sequenced-collections.html).

Find three idioms in your own code for "last element" or "reverse order" (`list.get(list.size() - 1)`, `Collections.reverse`, `LinkedHashSet` iteration tricks, `Deque.peekLast`). Rewrite with sequenced methods. Which one changes behavior on an empty collection (hint: exceptions)? Check the Javadoc of `getLast`.
