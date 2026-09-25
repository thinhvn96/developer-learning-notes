import java.io.*;
import java.util.*;

/** Run: java design-patterns/examples/DecoratorDemo.java  Wrap an object to add behavior while keeping its interface. */
public class DecoratorDemo {
    public static void main(String[] args) throws IOException {
        Coffee c = new Milk(new Sugar(new Espresso()));
        System.out.println(c.description() + " = " + c.cost());
        Coffee c2 = new Sugar(new Sugar(new Espresso()));                 // decorators can be stacked and repeated
        System.out.println(c2.description() + " = " + c2.cost());

        // JDK decorators: BufferedReader wraps any Reader, adding buffering and readLine().
        try (BufferedReader r = new BufferedReader(new StringReader("line1\nline2"))) { System.out.println("BufferedReader: " + r.readLine() + " | " + r.readLine()); }
        List<String> base = new ArrayList<>(List.of("a"));
        List<String> ro = Collections.unmodifiableList(base);              // wrapper that changes behavior of the mutators
        base.add("b");
        System.out.println("unmodifiable view reads through: " + ro);
        try { ro.add("c"); } catch (UnsupportedOperationException e) { System.out.println("writes rejected by the wrapper"); }
    }
}
interface Coffee { String description(); int cost(); }
class Espresso implements Coffee { public String description() { return "espresso"; } public int cost() { return 3; } }
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee inner; CoffeeDecorator(Coffee c) { inner = c; }
}
class Milk extends CoffeeDecorator { Milk(Coffee c) { super(c); } public String description() { return inner.description() + " + milk"; } public int cost() { return inner.cost() + 1; } }
class Sugar extends CoffeeDecorator { Sugar(Coffee c) { super(c); } public String description() { return inner.description() + " + sugar"; } public int cost() { return inner.cost() + 0; } }
