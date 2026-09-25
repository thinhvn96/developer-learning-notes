import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/** JDK 21. Compile check: javac --release 21 Jdk21Features.java   Run: java java/examples/jdk21/Jdk21Features.java */
public class Jdk21Features {

    sealed interface Shape permits Circle, Rect {}
    record Point(int x, int y) {}
    record Circle(Point center, double r) implements Shape {}
    record Rect(Point topLeft, Point bottomRight) implements Shape {}

    // Pattern matching for switch + record patterns. No default: the compiler checks the sealed hierarchy is covered.
    static String describe(Shape s) {
        return switch (s) {
            case Circle(Point(var x, var y), var r) when r > 100 -> "huge circle at " + x + "," + y;
            case Circle(Point(var x, var y), var r)              -> "circle r=" + r + " at " + x + "," + y;
            case Rect(Point(var x1, var y1), Point(var x2, var y2)) -> "rect width " + (x2 - x1) + " height " + (y2 - y1);
        };
    }

    static String nullSafe(Object o) {
        return switch (o) {
            case null -> "null handled inside the switch";
            case String str when str.isBlank() -> "blank string";
            case String str -> "string " + str;
            case Integer i -> "int " + i;
            default -> "other";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Circle(new Point(1, 2), 5)));
        System.out.println(describe(new Circle(new Point(0, 0), 500)));
        System.out.println(describe(new Rect(new Point(0, 0), new Point(4, 3))));
        System.out.println(nullSafe(null) + " | " + nullSafe(" ") + " | " + nullSafe("x") + " | " + nullSafe(7));

        // Sequenced collections
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        System.out.println(list.getFirst() + " " + list.getLast() + " " + list.reversed());
        var map = new LinkedHashMap<String, Integer>();
        map.put("one", 1); map.put("two", 2);
        System.out.println(map.firstEntry() + " " + map.lastEntry() + " " + map.reversed());
    }
}
