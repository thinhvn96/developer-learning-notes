import java.util.*;

/** Lesson 0032. Run: java java/examples/collections/UnmodifiableVsImmutable.java */
public class UnmodifiableVsImmutable {
    static String tryIt(Runnable r) {
        try { r.run(); return "ok"; } catch (RuntimeException e) { return e.getClass().getSimpleName(); }
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List<String> asList = Arrays.asList(arr);
        System.out.println("Arrays.asList   set: " + tryIt(() -> asList.set(0, "X"))
                + "  add: " + tryIt(() -> asList.add("d")) + "  -> array now " + Arrays.toString(arr));

        List<String> backing = new ArrayList<>(List.of("a", "b"));
        List<String> view = Collections.unmodifiableList(backing);
        List<String> copy = List.copyOf(backing);
        System.out.println("unmodifiableList add: " + tryIt(() -> view.add("x")));
        backing.add("c");
        System.out.println("after backing.add(\"c\"): view=" + view + "  copyOf=" + copy);

        System.out.println("List.of(null): " + tryIt(() -> List.of("a", null)));
        System.out.println("List.of contains(null): " + tryIt(() -> List.of("a").contains(null)));
        System.out.println("Arrays.asList with null: " + tryIt(() -> Arrays.asList("a", null)));
        System.out.println("Map.of duplicate key: " + tryIt(() -> Map.of("k", 1, "k", 2)));
        System.out.println("List.copyOf(List.of(..)) same instance? " + (List.copyOf(copy) == copy));

        // Shallow: the list is unmodifiable, the elements are not.
        List<StringBuilder> sbs = List.of(new StringBuilder("hi"));
        sbs.get(0).append(" there");
        System.out.println("List.of with mutable element: " + sbs);

        // Stream.toList (JDK 16) is unmodifiable; Collectors.toList makes no promise.
        List<Integer> fromStream = java.util.stream.Stream.of(1, 2).toList();
        System.out.println("Stream.toList add: " + tryIt(() -> fromStream.add(3)));
    }
}
