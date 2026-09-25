import java.util.*;

/** Run: java oop/examples/GodObjectDemo.java  A god object, then a decomposition into cohesive collaborators. */
public class GodObjectDemo {
    public static void main(String[] args) {
        System.out.println(new OrderManager().process("ann", List.of(10, 20, 30)));       // does everything

        Pricing pricing = new Pricing();
        Mailer mailer = new Mailer();
        OrderProcessor proc = new OrderProcessor(pricing, mailer);
        System.out.println(proc.process("ann", List.of(10, 20, 30)));
    }
}
/** Anti-pattern: validation, pricing, persistence, email and formatting all in one class. */
class OrderManager {
    String process(String customer, List<Integer> items) {
        if (customer == null || items.isEmpty()) throw new IllegalArgumentException();
        int total = items.stream().mapToInt(Integer::intValue).sum(); total = total > 50 ? total * 90 / 100 : total;
        System.out.println("  [god] INSERT order for " + customer);
        System.out.println("  [god] email " + customer + ": total " + total);
        return "god processed " + total;
    }
}
class Pricing { int total(List<Integer> items) { int t = items.stream().mapToInt(Integer::intValue).sum(); return t > 50 ? t * 90 / 100 : t; } }
class Mailer { void send(String to, String body) { System.out.println("  [mailer] " + to + ": " + body); } }
class OrderProcessor {
    private final Pricing pricing; private final Mailer mailer;
    OrderProcessor(Pricing p, Mailer m) { pricing = p; mailer = m; }
    String process(String customer, List<Integer> items) {
        int total = pricing.total(items);
        mailer.send(customer, "total " + total);
        return "processor processed " + total;
    }
}
