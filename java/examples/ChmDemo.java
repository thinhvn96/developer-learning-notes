import java.util.*;
import java.util.concurrent.*;

/** Run: java java/examples/ChmDemo.java */
public class ChmDemo {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        Thread[] ts = new Thread[4];
        for (int t = 0; t < ts.length; t++) {
            ts[t] = new Thread(() -> { for (int i = 0; i < 100_000; i++) counts.merge("hits", 1, Integer::sum); });
            ts[t].start();
        }
        for (Thread t : ts) t.join();
        System.out.println("merge() total   : " + counts.get("hits") + " (expected 400000)");

        try { counts.put(null, 1); } catch (NullPointerException e) { System.out.println("null key        : NullPointerException"); }

        // Weakly consistent iterator: modifying during iteration does not throw ConcurrentModificationException.
        ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>(Map.of(1, "a", 2, "b", 3, "c"));
        for (Integer k : m.keySet()) m.put(k + 10, "new");
        System.out.println("modified while iterating: no exception, size=" + m.size());

        // Plain HashMap in the same situation:
        Map<Integer, String> h = new HashMap<>(Map.of(1, "a", 2, "b", 3, "c"));
        try { for (Integer k : h.keySet()) h.put(k + 10, "new"); }
        catch (ConcurrentModificationException e) { System.out.println("HashMap          : ConcurrentModificationException"); }
    }
}
