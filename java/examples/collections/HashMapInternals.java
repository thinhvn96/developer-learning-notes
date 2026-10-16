import java.util.*;

/** Lesson 0030. Run: java java/examples/collections/HashMapInternals.java
 *  Reproduces HashMap's bucket-index math and measures what treeification buys. */
public class HashMapInternals {
    static int spread(int h) { return h ^ (h >>> 16); }          // same as HashMap.hash()

    // Every instance has the same hashCode: the worst case for any hash table.
    record BadKey(int id) { @Override public int hashCode() { return 42; } }
    record BadComparableKey(int id) implements Comparable<BadComparableKey> {
        @Override public int hashCode() { return 42; }
        @Override public int compareTo(BadComparableKey o) { return Integer.compare(id, o.id); }
    }

    public static void main(String[] args) {
        System.out.println("=== bucket index = (n - 1) & spread(hashCode), table size n = 16");
        for (String k : List.of("apple", "banana", "cherry", "Aa", "BB")) {
            int h = k.hashCode();
            System.out.printf("%-7s hashCode=%11d  index=%2d%n", k, h, (16 - 1) & spread(h));
        }
        System.out.println("('Aa' and 'BB' have the same String hashCode: a real collision)");

        System.out.println("=== after resize to n = 32 an entry stays at i or moves to i + 16");
        for (String k : List.of("apple", "banana", "cherry")) {
            int s = spread(k.hashCode());
            System.out.printf("%-7s n=16 -> %2d   n=32 -> %2d%n", k, 15 & s, 31 & s);
        }

        int n = 20_000;
        System.out.println("=== " + n + " keys that ALL share hashCode 42, then " + n + " lookups");
        System.out.printf("not Comparable : %5d ms%n", time(n, BadKey::new));
        System.out.printf("Comparable     : %5d ms%n", time(n, BadComparableKey::new));
    }

    static <K> long time(int n, java.util.function.IntFunction<K> make) {
        long t0 = System.nanoTime();
        Map<K, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(make.apply(i), i);
        long sum = 0;
        for (int i = 0; i < n; i++) sum += map.get(make.apply(i));
        if (sum < 0) System.out.println(sum);
        return (System.nanoTime() - t0) / 1_000_000;
    }
}
