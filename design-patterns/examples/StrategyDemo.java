import java.util.*;
import java.util.function.*;

/** Run: java design-patterns/examples/StrategyDemo.java  Interchangeable algorithms behind one interface; in modern Java a lambda is often enough. */
public class StrategyDemo {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("pear", "fig", "banana", "kiwi"));
        words.sort(Comparator.comparing(String::length));                    // Comparator is a strategy
        System.out.println("by length     : " + words);
        words.sort(Comparator.<String>naturalOrder().reversed());
        System.out.println("reverse alpha : " + words);

        Cart cart = new Cart(new NoDiscount2());
        System.out.println("no discount   : " + cart.total(200));
        cart.setStrategy(new PercentOff(10));                                 // swapped at runtime
        System.out.println("10% off       : " + cart.total(200));
        cart.setStrategy(price -> price - 25);                                // lambda strategy
        System.out.println("lambda -25    : " + cart.total(200));
    }
}
interface Pricing { int apply(int price); }
class NoDiscount2 implements Pricing { public int apply(int p) { return p; } }
class PercentOff implements Pricing { private final int pct; PercentOff(int p) { pct = p; } public int apply(int p) { return p * (100 - pct) / 100; } }
class Cart {
    private Pricing strategy; Cart(Pricing s) { strategy = s; }
    void setStrategy(Pricing s) { strategy = s; }
    int total(int subtotal) { return strategy.apply(subtotal); }
}
