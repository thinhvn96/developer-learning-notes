/** Run: java oop/examples/InitializationOrder.java  Order of static blocks, field initializers, instance blocks and constructors. */
public class InitializationOrder {
    public static void main(String[] args) {
        System.out.println("main starts");
        new Child();
        System.out.println("--- second object: static parts do not run again");
        new Child();
    }
}
class Parent {
    static { System.out.println("1 Parent static block"); }
    int p = log("3 Parent field initializer");
    { System.out.println("4 Parent instance block"); }
    Parent() { System.out.println("5 Parent constructor"); }
    static int log(String s) { System.out.println(s); return 0; }
}
class Child extends Parent {
    static { System.out.println("2 Child static block"); }
    int c = log("6 Child field initializer");
    { System.out.println("7 Child instance block"); }
    Child() { super(); System.out.println("8 Child constructor"); }
}
