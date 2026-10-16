# Exercise 0035: Top-K and scheduling

[Tiếng Việt](0035-top-k-and-scheduling.vi.md)

Companion to [lesson 35](../lessons/0035-priorityqueue-and-top-k.html).

1. Return the 10 most frequent words of a 2 GB log. Combine `merge` (counting) and a heap. Which heap, which size, which comparator? What is the complexity?
2. A teammate prints a `PriorityQueue` to "show the schedule in order". What will they see, and how should they print it?
3. Implement a simple job scheduler: jobs with a `runAt` time; a loop always runs the earliest job next. Which structure, and what is the cost of adding a job? Of cancelling one by id?
4. Merge K sorted lists of total size N with a heap. State the complexity.
