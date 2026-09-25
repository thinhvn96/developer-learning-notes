import java.util.*;

/** Run: java design-patterns/examples/FlyweightDemo.java  Share intrinsic state; pass extrinsic state in. */
public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println("Integer cache: valueOf(127)==valueOf(127) is " + (Integer.valueOf(127) == Integer.valueOf(127))
                + ", valueOf(1000)==valueOf(1000) is " + (Integer.valueOf(1000) == Integer.valueOf(1000)));

        String text = "hello world";
        List<Placed> placed = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) placed.add(new Placed(GlyphFactory.get(text.charAt(i), "Serif", 12), i, 0));   // x,y are extrinsic
        System.out.println("characters placed: " + placed.size() + ", distinct glyph objects created: " + GlyphFactory.created());
    }
}
record Glyph(char ch, String font, int size) { }                       // intrinsic state: immutable and shareable
class GlyphFactory {
    private static final Map<Glyph, Glyph> pool = new HashMap<>();
    static Glyph get(char c, String font, int size) { return pool.computeIfAbsent(new Glyph(c, font, size), g -> g); }
    static int created() { return pool.size(); }
}
record Placed(Glyph glyph, int x, int y) { }                           // extrinsic state (position) lives outside the flyweight
