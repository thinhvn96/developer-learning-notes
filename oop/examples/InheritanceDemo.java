/** Run: java oop/examples/InheritanceDemo.java  extends, super, constructor chaining, and 'is-a' with instanceof. */
public class InheritanceDemo {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(6, "full");
        mb.speedUp(12);                          // inherited from Bike
        System.out.println(mb.describe());       // overridden, calls super.describe()
        Bike b = mb;                             // a MountainBike IS-A Bike
        System.out.println("b instanceof MountainBike: " + (b instanceof MountainBike));
        System.out.println("new Bike() instanceof MountainBike: " + (new Bike(1) instanceof MountainBike));
    }
}
class Bike {
    protected int gear; protected int speed;
    Bike(int gear) { this.gear = gear; System.out.println("Bike constructor"); }
    void speedUp(int inc) { speed += inc; }
    String describe() { return "gear " + gear + ", speed " + speed; }
}
class MountainBike extends Bike {
    private final String suspension;
    MountainBike(int gear, String suspension) { super(gear); this.suspension = suspension; System.out.println("MountainBike constructor"); }
    @Override String describe() { return super.describe() + ", " + suspension + " suspension"; }
}
