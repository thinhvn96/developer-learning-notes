/** Run: java oop/examples/CouplingCohesion.java  Tight coupling (new inside) vs loose coupling (injected abstraction). */
public class CouplingCohesion {
    public static void main(String[] args) {
        TightOrderService tight = new TightOrderService();
        System.out.println(tight.place("book"));               // cannot be tested without the real database class

        FakeRepo fake = new FakeRepo();
        LooseOrderService loose = new LooseOrderService(fake); // dependency is passed in
        System.out.println(loose.place("book"));
        System.out.println("fake repo received: " + fake.saved);
    }
}
class SqlOrderRepo { void save(String item) { System.out.println("  (pretend SQL INSERT " + item + ")"); } }
class TightOrderService {
    private final SqlOrderRepo repo = new SqlOrderRepo();     // hard-wired concrete class
    String place(String item) { repo.save(item); return "tight: placed " + item; }
}
interface OrderRepo { void save(String item); }
class FakeRepo implements OrderRepo { String saved; public void save(String item) { saved = item; } }
class LooseOrderService {
    private final OrderRepo repo;                              // depends on the abstraction
    LooseOrderService(OrderRepo repo) { this.repo = repo; }
    String place(String item) { repo.save(item); return "loose: placed " + item; }
}
