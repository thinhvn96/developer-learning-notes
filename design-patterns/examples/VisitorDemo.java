import java.util.*;

/** Run: java design-patterns/examples/VisitorDemo.java  Add operations to a type hierarchy without changing it (classic double dispatch, then JDK 21 pattern matching). */
public class VisitorDemo {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(1), new Rect(2, 3));
        AreaVisitor area = new AreaVisitor(); PerimeterVisitor per = new PerimeterVisitor();
        for (Shape s : shapes) System.out.printf("%s area=%.2f perimeter=%.2f%n", s.getClass().getSimpleName(), s.accept(area), s.accept(per));

        // The same operation with a sealed hierarchy + pattern-matching switch (JDK 21): the compiler checks exhaustiveness.
        for (Shape s : shapes) System.out.printf("switch: %s area=%.2f%n", s.getClass().getSimpleName(), areaBySwitch(s));
    }
    static double areaBySwitch(Shape s) { return switch (s) { case Circle c -> Math.PI * c.r * c.r; case Rect r -> r.w * r.h; }; }
}
interface Visitor<R> { R visit(Circle c); R visit(Rect r); }
sealed interface Shape permits Circle, Rect { <R> R accept(Visitor<R> v); }        // double dispatch: accept() picks visit(Circle) or visit(Rect)
final class Circle implements Shape { final double r; Circle(double r) { this.r = r; } public <R> R accept(Visitor<R> v) { return v.visit(this); } }
final class Rect implements Shape { final double w, h; Rect(double w, double h) { this.w = w; this.h = h; } public <R> R accept(Visitor<R> v) { return v.visit(this); } }
class AreaVisitor implements Visitor<Double> { public Double visit(Circle c) { return Math.PI * c.r * c.r; } public Double visit(Rect r) { return r.w * r.h; } }
class PerimeterVisitor implements Visitor<Double> { public Double visit(Circle c) { return 2 * Math.PI * c.r; } public Double visit(Rect r) { return 2 * (r.w + r.h); } }
