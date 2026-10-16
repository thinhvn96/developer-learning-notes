import java.util.*;
import java.util.concurrent.*;

/** Lesson 0028. Run: java java/examples/collections/FrameworkMap.java
 *  Prints which core interfaces each common implementation implements. */
public class FrameworkMap {
    static final List<Class<?>> IFACES = List.of(List.class, Set.class, SortedSet.class, NavigableSet.class,
            Queue.class, Deque.class, SequencedCollection.class, Map.class, NavigableMap.class, SequencedMap.class,
            RandomAccess.class);

    public static void main(String[] args) {
        Object[] impls = { new ArrayList<>(), new LinkedList<>(), new ArrayDeque<>(), new PriorityQueue<>(),
                new HashSet<>(), new LinkedHashSet<>(), new TreeSet<>(),
                new HashMap<>(), new LinkedHashMap<>(), new TreeMap<>(), new ConcurrentHashMap<>() };
        for (Object o : impls) {
            List<String> names = new ArrayList<>();
            for (Class<?> i : IFACES) if (i.isInstance(o)) names.add(i.getSimpleName());
            System.out.printf("%-18s %s%n", o.getClass().getSimpleName(), String.join(", ", names));
        }
    }
}
