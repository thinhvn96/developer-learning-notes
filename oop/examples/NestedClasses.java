import java.util.*;

/** Run: java oop/examples/NestedClasses.java  Static nested vs inner vs local/anonymous classes. */
public class NestedClasses {
    private int secret = 7;
    private static int staticSecret = 99;

    class Inner {                                 // tied to an instance; can read private members of the outer object
        int peek() { return secret; }
    }
    static class StaticNested {                   // no outer instance; can only reach the outer's static members
        int peek() { return staticSecret; }
    }

    public static void main(String[] args) {
        NestedClasses outer = new NestedClasses();
        NestedClasses.Inner in = outer.new Inner();
        System.out.println("inner sees outer's private field      : " + in.peek());
        System.out.println("static nested sees only static members : " + new StaticNested().peek());

        int base = 10;                            // effectively final: captured by the local class and the anonymous class
        class Local { int plus(int x) { return x + base; } }
        Comparator<String> byLength = new Comparator<>() {          // anonymous class
            @Override public int compare(String a, String b) { return Integer.compare(a.length(), b.length()); }
        };
        List<String> words = new ArrayList<>(List.of("ccc", "a", "bb"));
        words.sort(byLength);
        System.out.println("local class: " + new Local().plus(5) + ", anonymous comparator sorted: " + words);
    }
}
