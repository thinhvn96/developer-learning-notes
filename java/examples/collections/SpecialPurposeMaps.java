import java.util.*;

/** Lesson 0036. Run: java java/examples/collections/SpecialPurposeMaps.java */
public class SpecialPurposeMaps {
    enum Status { NEW, PAID, SHIPPED, DELIVERED, CANCELLED }

    public static void main(String[] args) throws Exception {
        EnumMap<Status, Integer> counts = new EnumMap<>(Status.class);
        counts.put(Status.SHIPPED, 4); counts.put(Status.NEW, 7); counts.put(Status.CANCELLED, 1);
        System.out.println("EnumMap (declaration order): " + counts);

        EnumSet<Status> open = EnumSet.range(Status.NEW, Status.SHIPPED);
        System.out.println("EnumSet.range(NEW, SHIPPED): " + open + "   complement: " + EnumSet.complementOf(open));

        String k1 = new String("id-1"), k2 = new String("id-1");
        Map<String, String> hash = new HashMap<>(), identity = new IdentityHashMap<>();
        hash.put(k1, "v"); hash.put(k2, "v");
        identity.put(k1, "v"); identity.put(k2, "v");
        System.out.println("equal strings: HashMap size " + hash.size() + ", IdentityHashMap size " + identity.size());

        Map<Object, String> weak = new WeakHashMap<>();
        Object key = new Object();
        weak.put(key, "metadata");
        System.out.println("WeakHashMap before: " + weak.size());
        key = null;                                   // drop the only strong reference
        for (int i = 0; i < 20 && !weak.isEmpty(); i++) { System.gc(); Thread.sleep(50); }
        System.out.println("WeakHashMap after GC: " + weak.size() + "  (GC timing is not guaranteed)");
    }
}
