import java.util.List;

/** Run: java oop/examples/PolymorphismDemo.java  Overriding is chosen at runtime, overloading at compile time. */
public class PolymorphismDemo {
    static String describe(Shape s)  { return "describe(Shape)"; }
    static String describe(Circle c) { return "describe(Circle)"; }

    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(1), new Square(2), new Circle(0.5));
        double total = 0;
        for (Shape s : shapes) {                 // one loop, many behaviours: virtual method invocation
            System.out.printf("%-7s area=%.2f%n", s.getClass().getSimpleName(), s.area());
            total += s.area();
        }
        System.out.printf("total=%.2f%n", total);
        Shape s = new Circle(1);
        System.out.println("overload chosen for a Shape-typed variable holding a Circle: " + describe(s));
    }
}
interface Shape { double area(); }
record Circle(double r) implements Shape { public double area() { return Math.PI * r * r; } }
record Square(double side) implements Shape { public double area() { return side * side; } }
