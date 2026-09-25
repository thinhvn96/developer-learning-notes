import java.util.*;

/** Run: java design-patterns/examples/TemplateMethodDemo.java  The base class fixes the algorithm skeleton; subclasses fill in steps. */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        new CsvReport().generate();
        new HtmlReport().generate();
        AbstractList<Integer> squares = new AbstractList<>() {               // JDK example: implement get() and size(), inherit the rest
            public Integer get(int i) { return i * i; } public int size() { return 5; }
        };
        System.out.println("AbstractList (template) gives contains/indexOf/iterator for free: " + squares + " contains 9? " + squares.contains(9));
    }
}
abstract class Report {
    final void generate() {                                                  // the template method: final, so the order cannot change
        String header = header(); String body = body();
        System.out.println(header + "|" + body + "|" + footer());
    }
    abstract String header(); abstract String body();
    String footer() { return "end"; }                                        // hook with a default
}
class CsvReport extends Report { String header() { return "a,b"; } String body() { return "1,2"; } }
class HtmlReport extends Report { String header() { return "<h1>"; } String body() { return "<p>1</p>"; } @Override String footer() { return "</html>"; } }
