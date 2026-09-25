import java.util.HashMap;
import java.util.Map;

/** Run: java system-design/examples/CacheAsideDemo.java */
public class CacheAsideDemo {
    static final Map<Integer, String> store = new HashMap<>();   // the "database"
    static final Map<Integer, String> cache = new HashMap<>();   // the cache
    static int storeReads = 0;

    static String read(int id) {
        String v = cache.get(id);
        if (v != null) return v;                 // hit
        storeReads++;                            // miss: go to the store
        v = store.get(id);
        if (v != null) cache.put(id, v);         // add to cache, avoid caching null
        return v;
    }

    static void write(int id, String value) {
        store.put(id, value);                    // 1. update the data store
        cache.remove(id);                        // 2. then invalidate the cache
    }

    public static void main(String[] args) {
        store.put(1, "v1");
        System.out.println("read: " + read(1) + "  (store reads so far: " + storeReads + ")");
        System.out.println("read: " + read(1) + "  (store reads so far: " + storeReads + ")");

        write(1, "v2");
        System.out.println("after write+invalidate: " + read(1) + "  (store reads: " + storeReads + ")");

        // Something else changes the store behind the cache's back: no consistency guarantee.
        store.put(1, "v3");
        System.out.println("after out-of-band change, cache still says: " + read(1) + "  (stale)");
    }
}
