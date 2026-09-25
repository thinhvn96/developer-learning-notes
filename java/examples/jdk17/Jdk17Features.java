/** JDK 17. Compile check: javac --release 17 Jdk17Features.java   Run: java java/examples/jdk17/Jdk17Features.java */
public class Jdk17Features {

    sealed interface Shape permits Circle, Square, Rect {}
    record Circle(double r) implements Shape {}
    record Square(double side) implements Shape {}
    record Rect(double w, double h) implements Shape {}

    // Switch EXPRESSION over the sealed type. In 17 this uses instanceof checks instead (pattern switch is 21).
    static double area(Shape s) {
        if (s instanceof Circle c) return Math.PI * c.r() * c.r();          // pattern matching for instanceof
        if (s instanceof Square q) return q.side() * q.side();
        if (s instanceof Rect r) return r.w() * r.h();
        throw new IllegalStateException();
    }

    static String describe(int day) {
        return switch (day) {                                               // switch expression
            case 6, 7 -> "weekend";
            case 1, 2, 3, 4, 5 -> "weekday";
            default -> {
                String msg = "invalid: " + day;
                yield msg;                                                  // yield returns from a block
            }
        };
    }

    public static void main(String[] args) {
        var json = """
                {
                  "name": "orders",
                  "port": 8080
                }
                """;                                                        // text block, var
        System.out.print(json);
        System.out.println(describe(6) + ", " + describe(2) + ", " + describe(9));
        System.out.printf("%.2f %.2f %.2f%n", area(new Circle(1)), area(new Square(2)), area(new Rect(2, 3)));
    }
}
