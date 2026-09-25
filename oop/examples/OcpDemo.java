import java.util.*;

/** Run: java oop/examples/OcpDemo.java  Open for extension, closed for modification. */
public class OcpDemo {
    static int priceWithSwitch(String customerType, int price) {         // to add "vip", this method must be EDITED
        return switch (customerType) { case "regular" -> price; case "student" -> price * 90 / 100; default -> price; };
    }
    public static void main(String[] args) {
        System.out.println("switch version: " + priceWithSwitch("student", 100));

        List<Discount> discounts = new ArrayList<>(List.of(new NoDiscount(), new StudentDiscount()));
        discounts.add(new VipDiscount());                               // extension: new class, existing code untouched
        for (Discount d : discounts) System.out.println(d.getClass().getSimpleName() + " -> " + d.apply(100));
    }
}
interface Discount { int apply(int price); }
class NoDiscount implements Discount { public int apply(int p) { return p; } }
class StudentDiscount implements Discount { public int apply(int p) { return p * 90 / 100; } }
class VipDiscount implements Discount { public int apply(int p) { return p * 80 / 100; } }
