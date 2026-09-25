/** JDK 8. Compile check: javac --release 8 DefaultMethods.java */
public class DefaultMethods {
    interface Walker { default String move() { return "walk"; } }
    interface Swimmer { default String move() { return "swim"; } }

    // Two interfaces supply the same default: the class MUST resolve the conflict.
    static class Duck implements Walker, Swimmer {
        @Override public String move() { return Walker.super.move() + " and " + Swimmer.super.move(); }
    }

    // A concrete class method always wins over an interface default ("class wins").
    static class Base { public String move() { return "base"; } }
    static class Robot extends Base implements Walker { }

    public static void main(String[] args) {
        System.out.println(new Duck().move());
        System.out.println(new Robot().move());
    }
}
