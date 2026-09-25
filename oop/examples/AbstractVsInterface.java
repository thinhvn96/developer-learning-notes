/** Run: java oop/examples/AbstractVsInterface.java  Abstract class = shared code and state; interface = a capability contract. */
public class AbstractVsInterface {
    public static void main(String[] args) {
        Robot r = new Robot("r2");
        r.report();
        r.start();                               // from the Machine abstract class (shared code)
        r.charge();                              // from the Chargeable interface (default method)
        System.out.println("Robot is a Machine: " + (r instanceof Machine) + ", is Chargeable: " + (r instanceof Chargeable)
                + ", is Swimmer: " + (r instanceof Swimmer));
        // new Machine("x");   // compile error: abstract classes cannot be instantiated
    }
}
abstract class Machine {
    protected final String name; private boolean running;
    Machine(String name) { this.name = name; }
    void start() { running = true; System.out.println(name + " started, running=" + running); }   // concrete, shared
    abstract void report();                                                                       // subclasses must implement
}
interface Chargeable { int level(); default void charge() { System.out.println("charging from level " + level()); } }
interface Swimmer { void swim(); }
class Robot extends Machine implements Chargeable {      // one superclass, many interfaces
    Robot(String n) { super(n); }
    @Override void report() { System.out.println("robot " + name + " reporting"); }
    public int level() { return 42; }
}
