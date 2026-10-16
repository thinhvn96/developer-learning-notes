import java.util.*;
import java.util.stream.*;

/** Lesson 0037. Run: java java/examples/collections/MapPowerMethods.java */
public class MapPowerMethods {
    public static void main(String[] args) {
        List<String> words = List.of("kafka", "java", "kafka", "sql", "java", "kafka");

        Map<String, Integer> counts = new TreeMap<>();
        for (String w : words) counts.merge(w, 1, Integer::sum);
        System.out.println("merge count         : " + counts);

        Map<Character, List<String>> byFirst = new TreeMap<>();
        for (String w : words) byFirst.computeIfAbsent(w.charAt(0), c -> new ArrayList<>()).add(w);
        System.out.println("computeIfAbsent list: " + byFirst);

        System.out.println("getOrDefault        : " + counts.getOrDefault("go", 0));

        // putIfAbsent ALWAYS builds the argument; computeIfAbsent only when needed.
        Map<String, List<String>> m = new HashMap<>();
        m.put("x", new ArrayList<>());
        int[] built = {0};
        m.putIfAbsent("x", track(built));
        m.computeIfAbsent("x", k -> track(built));
        System.out.println("objects built (putIfAbsent + computeIfAbsent on existing key): " + built[0]);

        // Returning null means "no mapping".
        Map<String, Integer> stock = new HashMap<>(Map.of("apple", 1));
        stock.computeIfAbsent("pear", k -> null);
        stock.computeIfPresent("apple", (k, v) -> v - 1 == 0 ? null : v - 1);
        System.out.println("null result removes : " + stock);

        // getOrDefault trap: a key mapped to null is "present".
        Map<String, String> nullable = new HashMap<>();
        nullable.put("k", null);
        System.out.println("getOrDefault on null value: " + nullable.getOrDefault("k", "default"));

        // Modifying the map from inside the mapping function: HashMap detects it.
        Map<Integer, Integer> memo = new HashMap<>();
        try {
            fib(30, memo);
        } catch (ConcurrentModificationException e) {
            System.out.println("recursive computeIfAbsent: ConcurrentModificationException");
        }

        System.out.println("groupingBy+counting : " + words.stream()
                .collect(Collectors.groupingBy(w -> w, TreeMap::new, Collectors.counting())));
    }

    static List<String> track(int[] built) { built[0]++; return new ArrayList<>(); }

    static int fib(int n, Map<Integer, Integer> memo) {      // the classic memoization mistake
        if (n < 2) return n;
        return memo.computeIfAbsent(n, k -> fib(k - 1, memo) + fib(k - 2, memo));
    }
}
