import java.util.*;

/** Run: java design-patterns/examples/AdapterDemo.java  Make an incompatible interface fit the one your client expects. */
public class AdapterDemo {
    public static void main(String[] args) {
        // Your client expects Printer. The legacy class has a different method name and unit.
        Printer p = new LegacyAdapter(new LegacyPrinter());
        p.print("hello");

        // JDK adapter: an array seen as a List (write-through view).
        String[] array = {"a", "b", "c"};
        List<String> view = Arrays.asList(array);
        view.set(0, "x");
        array[1] = "y";
        System.out.println("array=" + Arrays.toString(array) + " view=" + view);
        try { view.add("d"); } catch (UnsupportedOperationException e) { System.out.println("fixed-size: add() unsupported"); }
    }
}
interface Printer { void print(String text); }
class LegacyPrinter { void output(char[] chars, int lengthInBytes) { System.out.println("legacy printed " + lengthInBytes + " bytes: " + new String(chars)); } }
class LegacyAdapter implements Printer {                   // object adapter: wraps the adaptee
    private final LegacyPrinter adaptee;
    LegacyAdapter(LegacyPrinter a) { adaptee = a; }
    public void print(String text) { adaptee.output(text.toCharArray(), text.length()); }
}
