import java.util.*;

/** Lesson 0038. Run: java -Xmx1g java/examples/collections/CapacityAndBoxing.java
 *  Timings and memory numbers are rough single-run measurements, not a benchmark. */
public class CapacityAndBoxing {
    public static void main(String[] args) {
        // 1. ArrayList growth: simulate the documented source rule (default 10, then old + old/2).
        List<Integer> caps = new ArrayList<>();
        int cap = 10;
        while (cap < 1_000) { caps.add(cap); cap = cap + (cap >> 1); }
        System.out.println("ArrayList capacities: " + caps + " ...");

        // 2. Boxing identity.
        Integer a = 127, b = 127, c = 128, d = 128;
        System.out.println("Integer 127 == 127: " + (a == b) + "   128 == 128: " + (c == d) + "   128 equals: " + c.equals(d));

        // 3. Removing from a List<Integer>: remove(int index) vs remove(Object).
        List<Integer> nums = new ArrayList<>(List.of(10, 20, 30));
        nums.remove(1);                       // index 1
        nums.remove(Integer.valueOf(10));     // the value 10
        System.out.println("remove(1) then remove(Integer.valueOf(10)): " + nums);

        // 4. Rough memory: 1,000,000 ints in four containers.
        int n = 1_000_000;
        System.out.printf("int[]               ~%3d MB%n", mb(() -> { int[] x = new int[n]; for (int i = 0; i < n; i++) x[i] = i + 1000; return x; }));
        System.out.printf("ArrayList<Integer>  ~%3d MB%n", mb(() -> { var x = new ArrayList<Integer>(n); for (int i = 0; i < n; i++) x.add(i + 1000); return x; }));
        System.out.printf("LinkedList<Integer> ~%3d MB%n", mb(() -> { var x = new LinkedList<Integer>(); for (int i = 0; i < n; i++) x.add(i + 1000); return x; }));
        System.out.printf("HashSet<Integer>    ~%3d MB%n", mb(() -> { var x = new HashSet<Integer>(); for (int i = 0; i < n; i++) x.add(i + 1000); return x; }));

        // 5. Presizing a HashMap (JDK 19+ factory) vs letting it rehash.
        System.out.printf("HashMap default      : %3d ms%n", fill(new HashMap<>()));
        System.out.printf("HashMap.newHashMap(n): %3d ms%n", fill(HashMap.newHashMap(2_000_000)));
    }

    static Object keep;
    static long mb(java.util.function.Supplier<Object> build) {
        Runtime rt = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) System.gc();
        long before = rt.totalMemory() - rt.freeMemory();
        keep = build.get();
        for (int i = 0; i < 3; i++) System.gc();
        long after = rt.totalMemory() - rt.freeMemory();
        keep = null;
        return (after - before) / (1024 * 1024);
    }

    static long fill(Map<Integer, Integer> m) {
        long t0 = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++) m.put(i, i);
        return (System.nanoTime() - t0) / 1_000_000;
    }
}
