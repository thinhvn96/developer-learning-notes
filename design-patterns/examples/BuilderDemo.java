/** Run: java design-patterns/examples/BuilderDemo.java  Step-by-step construction instead of a telescoping constructor. */
public class BuilderDemo {
    public static void main(String[] args) {
        // Telescoping constructor: which of these arguments is which?
        Pizza a = new Pizza("large", true, false, true, false, 2);
        System.out.println(a);
        Pizza b = new Pizza.Builder("large").cheese().mushrooms().extraToppings(2).build();   // readable, optional steps only
        System.out.println(b);
        System.out.println("StringBuilder is the JDK's best-known builder: " + new StringBuilder().append("a").append(1).append('!'));
        try { new Pizza.Builder("").build(); } catch (IllegalStateException e) { System.out.println("build() validates: " + e.getMessage()); }
    }
}
class Pizza {
    private final String size; private final boolean cheese, pepperoni, mushrooms, olives; private final int extra;
    Pizza(String size, boolean cheese, boolean pepperoni, boolean mushrooms, boolean olives, int extra) {
        this.size = size; this.cheese = cheese; this.pepperoni = pepperoni; this.mushrooms = mushrooms; this.olives = olives; this.extra = extra;
    }
    public String toString() { return "Pizza(" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + ", olives=" + olives + ", extra=" + extra + ")"; }
    static class Builder {
        private final String size; private boolean cheese, pepperoni, mushrooms, olives; private int extra;
        Builder(String size) { this.size = size; }
        Builder cheese() { cheese = true; return this; }
        Builder pepperoni() { pepperoni = true; return this; }
        Builder mushrooms() { mushrooms = true; return this; }
        Builder olives() { olives = true; return this; }
        Builder extraToppings(int n) { extra = n; return this; }
        Pizza build() { if (size.isBlank()) throw new IllegalStateException("size is required"); return new Pizza(size, cheese, pepperoni, mushrooms, olives, extra); }
    }
}
