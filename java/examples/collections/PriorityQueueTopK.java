import java.util.*;

/** Lesson 0035. Run: java java/examples/collections/PriorityQueueTopK.java */
public class PriorityQueueTopK {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(7, 3, 9, 1, 5, 8));
        System.out.println("toString (heap array order): " + pq);
        System.out.println("peek (smallest)            : " + pq.peek());
        List<Integer> drained = new ArrayList<>();
        PriorityQueue<Integer> copy = new PriorityQueue<>(pq);
        while (!copy.isEmpty()) drained.add(copy.poll());
        System.out.println("poll until empty           : " + drained);

        // Top-K largest of a stream with a MIN-heap of size k: O(n log k) time, O(k) memory.
        int k = 3;
        Random rnd = new Random(42);
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < 1_000_000; i++) {
            int x = rnd.nextInt(10_000_000);
            if (heap.size() < k) heap.offer(x);
            else if (x > heap.peek()) { heap.poll(); heap.offer(x); }
        }
        List<Integer> top = new ArrayList<>(heap);
        top.sort(Comparator.reverseOrder());
        System.out.println("top 3 of 1,000,000         : " + top);

        // Max-heap: pass a comparator.
        PriorityQueue<String> longestFirst = new PriorityQueue<>(Comparator.comparingInt(String::length).reversed());
        longestFirst.addAll(List.of("kafka", "jvm", "kubernetes", "sql"));
        System.out.println("max-heap by length poll    : " + longestFirst.poll());

        // Deque as a stack (LIFO) and as a queue (FIFO).
        Deque<String> stack = new ArrayDeque<>();
        stack.push("a"); stack.push("b"); stack.push("c");
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("a"); queue.offer("b"); queue.offer("c");
        System.out.println("stack pop: " + stack.pop() + "   queue poll: " + queue.poll());
    }
}
