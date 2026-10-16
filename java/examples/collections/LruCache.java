import java.util.*;

/** Lesson 0033. Run: java java/examples/collections/LruCache.java */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LruCache(int capacity) {
        super(16, 0.75f, true);            // accessOrder = true: get() moves an entry to the end
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;          // called by put after inserting
    }

    public static void main(String[] args) {
        Map<String, Integer> insertion = new LinkedHashMap<>();
        insertion.put("c", 3); insertion.put("a", 1); insertion.put("b", 2); insertion.put("a", 10);
        System.out.println("insertion order (re-put 'a' keeps its place): " + insertion);

        Set<String> hs = new HashSet<>(List.of("kafka", "java", "docker", "sql", "redis"));
        Set<String> lhs = new LinkedHashSet<>(List.of("kafka", "java", "docker", "sql", "redis"));
        System.out.println("HashSet: " + hs + "   LinkedHashSet: " + lhs);

        LruCache<String, Integer> cache = new LruCache<>(3);
        cache.put("a", 1); cache.put("b", 2); cache.put("c", 3);
        cache.get("a");                    // a becomes most recently used
        cache.put("d", 4);                 // evicts the least recently used: b
        System.out.println("LRU after get(a), put(d): " + cache.keySet());
        cache.put("e", 5);
        System.out.println("LRU after put(e):         " + cache.keySet());
    }
}
