import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Run: java java/examples/ListPitfalls.java */
public class ListPitfalls {
    public static void main(String[] args) {
        // 1. ArrayDeque prohibits null elements.
        Deque<String> deque = new ArrayDeque<>();
        try {
            deque.addFirst(null);
        } catch (NullPointerException e) {
            System.out.println("ArrayDeque rejects null: NullPointerException");
        }

        // 2. Structural modification while iterating: fail-fast iterator.
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        try {
            for (Integer x : list) {
                if (x == 2) list.remove(x);
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("for-each + list.remove: ConcurrentModificationException");
        }

        // 3. The safe ways.
        list.removeIf(x -> x % 2 == 0);
        System.out.println("removeIf result: " + list);
    }
}
