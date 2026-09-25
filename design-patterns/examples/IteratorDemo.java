import java.util.*;

/** Run: java design-patterns/examples/IteratorDemo.java  Traverse a collection without exposing its structure. */
public class IteratorDemo {
    public static void main(String[] args) {
        Countdown cd = new Countdown(3);
        for (int n : cd) System.out.print(n + " ");                 // for-each works on any Iterable
        System.out.println();
        Iterator<Integer> a = cd.iterator(), b = cd.iterator();      // independent iterators over the same collection
        a.next(); a.next();
        System.out.println("a is at " + a.next() + ", b is still at " + b.next());
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) if (it.next() % 2 == 0) it.remove();   // safe removal through the iterator
        System.out.println("removed evens via iterator: " + list);
    }
}
class Countdown implements Iterable<Integer> {
    private final int from; Countdown(int f) { from = f; }
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int current = from;
            public boolean hasNext() { return current > 0; }
            public Integer next() { return current--; }
        };
    }
}
