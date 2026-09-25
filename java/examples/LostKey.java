import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Run: java java/examples/LostKey.java */
public class LostKey {

    /** Broken: equals() is overridden, hashCode() is not. */
    static class BadKey {
        final String id;
        BadKey(String id) { this.id = id; }
        @Override public boolean equals(Object o) {
            return o instanceof BadKey k && k.id.equals(id);
        }
    }

    /** Correct: equal objects share a hash code. */
    static class GoodKey {
        final String id;
        GoodKey(String id) { this.id = id; }
        @Override public boolean equals(Object o) {
            return o instanceof GoodKey k && k.id.equals(id);
        }
        @Override public int hashCode() { return Objects.hash(id); }
    }

    public static void main(String[] args) {
        Map<BadKey, String> bad = new HashMap<>();
        bad.put(new BadKey("a"), "value");
        System.out.println("BadKey  lookup: " + bad.get(new BadKey("a")));

        Map<GoodKey, String> good = new HashMap<>();
        good.put(new GoodKey("a"), "value");
        System.out.println("GoodKey lookup: " + good.get(new GoodKey("a")));
    }
}
