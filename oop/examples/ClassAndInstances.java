/** Run: java oop/examples/ClassAndInstances.java  One class (blueprint), many instances (each with its own state). */
public class ClassAndInstances {
    public static void main(String[] args) {
        Bicycle a = new Bicycle();               // uses the no-arg constructor
        Bicycle b = new Bicycle(3, 20);          // uses the two-arg constructor
        a.speedUp(10); b.speedUp(5);
        a.print(); b.print();
        Bicycle alias = a;                       // a second reference to the SAME object
        alias.speedUp(1);
        System.out.println("a after alias.speedUp(1): " + a.speed + "   b unchanged: " + b.speed);
        System.out.println("a == alias: " + (a == alias) + ", a == b: " + (a == b));
    }
}
class Bicycle {
    int gear, speed;
    Bicycle() { this(1, 0); }                    // constructor chaining with this(...)
    Bicycle(int gear, int speed) { this.gear = gear; this.speed = speed; }
    void speedUp(int inc) { speed += inc; }
    void print() { System.out.println("gear=" + gear + " speed=" + speed); }
}
