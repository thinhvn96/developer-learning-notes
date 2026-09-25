/** Run: java oop/examples/LspDemo.java  A Square that extends Rectangle breaks callers written against Rectangle. */
public class LspDemo {
    static void resizeAndCheck(Rectangle r) {                              // written against the Rectangle contract
        r.setWidth(5); r.setHeight(4);
        System.out.println(r.getClass().getSimpleName() + ": area = " + r.area() + " (expected 20)");
    }
    public static void main(String[] args) {
        resizeAndCheck(new Rectangle());
        resizeAndCheck(new Square());                                      // substitutable? NO
        Shape2 s1 = new Rect2(5, 4), s2 = new Sq2(4);                       // fix: separate types under a common abstraction
        System.out.println("fixed design areas: " + s1.area() + ", " + s2.area());
    }
}
class Rectangle {
    protected int w, h;
    void setWidth(int w) { this.w = w; } void setHeight(int h) { this.h = h; }
    int area() { return w * h; }
}
class Square extends Rectangle {
    @Override void setWidth(int w) { this.w = w; this.h = w; }             // strengthens the invariant: breaks callers
    @Override void setHeight(int h) { this.w = h; this.h = h; }
}
interface Shape2 { int area(); }
record Rect2(int w, int h) implements Shape2 { public int area() { return w * h; } }
record Sq2(int side) implements Shape2 { public int area() { return side * side; } }
