/** Run: java oop/examples/IspDemo.java  Many small role interfaces instead of one fat interface. */
public class IspDemo {
    public static void main(String[] args) {
        FatWorker robot = new FatRobot();
        try { robot.eat(); } catch (UnsupportedOperationException e) { System.out.println("fat interface: Robot forced to implement eat() -> " + e.getMessage()); }

        Workable r = new Robot(); Feedable h = new Human(); Workable h2 = new Human();
        r.work(); h.eat(); h2.work();                                      // each client depends only on what it uses
    }
}
interface FatWorker { void work(); void eat(); }
class FatRobot implements FatWorker {
    public void work() { System.out.println("fat robot works"); }
    public void eat() { throw new UnsupportedOperationException("robots do not eat"); }
}
interface Workable { void work(); }
interface Feedable { void eat(); }
class Robot implements Workable { public void work() { System.out.println("robot works"); } }
class Human implements Workable, Feedable {
    public void work() { System.out.println("human works"); }
    public void eat() { System.out.println("human eats"); }
}
