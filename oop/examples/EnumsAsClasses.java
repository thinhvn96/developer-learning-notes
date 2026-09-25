import java.util.*;

/** Run: java oop/examples/EnumsAsClasses.java  An enum is a class with a fixed set of instances. */
public class EnumsAsClasses {
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6), EARTH(5.976e+24, 6.37814e6);
        static final double G = 6.67300E-11;
        private final double mass, radius;
        Planet(double mass, double radius) { this.mass = mass; this.radius = radius; }   // constructor is private
        double surfaceGravity() { return G * mass / (radius * radius); }
    }
    enum Op {                                     // constant-specific behavior: a tiny strategy per constant
        ADD { int apply(int a, int b) { return a + b; } },
        MUL { int apply(int a, int b) { return a * b; } };
        abstract int apply(int a, int b);
    }
    public static void main(String[] args) {
        for (Planet p : Planet.values()) System.out.printf("%-8s gravity %.2f%n", p, p.surfaceGravity());
        for (Op op : Op.values()) System.out.println(op + " 6,7 -> " + op.apply(6, 7));
        System.out.println("valueOf(\"EARTH\") == Planet.EARTH : " + (Planet.valueOf("EARTH") == Planet.EARTH));
        EnumMap<Op, Integer> uses = new EnumMap<>(Op.class);
        uses.merge(Op.ADD, 1, Integer::sum); uses.merge(Op.ADD, 1, Integer::sum);
        System.out.println("EnumMap: " + uses);
        try { Planet.valueOf("PLUTO"); } catch (IllegalArgumentException e) { System.out.println("no such constant: " + e.getMessage()); }
    }
}
