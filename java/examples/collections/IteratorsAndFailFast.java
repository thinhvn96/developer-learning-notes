import java.util.*;

/** Lesson 0029. Run: java java/examples/collections/IteratorsAndFailFast.java */
public class IteratorsAndFailFast {
    public static void main(String[] args) {
        // 1. One thread, no concurrency at all, still a ConcurrentModificationException.
        List<String> names = new ArrayList<>(List.of("ann", "bob", "cid", "dan"));
        try {
            for (String n : names) if (n.startsWith("b")) names.remove(n);
        } catch (ConcurrentModificationException e) {
            System.out.println("1. for-each + list.remove        -> ConcurrentModificationException");
        }

        // 2. The famous exception to the exception: removing the second-to-last element "works".
        List<String> tricky = new ArrayList<>(List.of("ann", "bob", "cid"));
        for (String n : tricky) if (n.equals("bob")) tricky.remove(n);
        System.out.println("2. remove 2nd-to-last in for-each -> no exception, list=" + tricky + "  (loop silently skipped 'cid')");

        // 3. Correct ways.
        List<String> a = new ArrayList<>(List.of("ann", "bob", "cid", "dan"));
        for (Iterator<String> it = a.iterator(); it.hasNext(); ) if (it.next().startsWith("b")) it.remove();
        System.out.println("3. Iterator.remove()              -> " + a);
        List<String> b = new ArrayList<>(List.of("ann", "bob", "cid", "dan"));
        b.removeIf(n -> n.startsWith("b"));
        System.out.println("4. removeIf (JDK 8)               -> " + b);

        // 4. ListIterator can replace and insert while walking.
        List<String> c = new ArrayList<>(List.of("ann", "bob"));
        for (ListIterator<String> it = c.listIterator(); it.hasNext(); ) {
            String n = it.next();
            it.set(n.toUpperCase());
            it.add(n + "!");
        }
        System.out.println("5. ListIterator set + add         -> " + c);

        // 5. HashMap: modifying values is fine, structural changes are not.
        Map<String, Integer> m = new HashMap<>(Map.of("a", 1, "b", 2));
        for (Map.Entry<String, Integer> e : m.entrySet()) e.setValue(e.getValue() * 10);
        System.out.println("6. entry.setValue while iterating -> " + new TreeMap<>(m));
        try {
            for (String k : m.keySet()) m.put(k + "x", 0);
        } catch (ConcurrentModificationException e) {
            System.out.println("7. map.put new key while iterating -> ConcurrentModificationException");
        }
    }
}
