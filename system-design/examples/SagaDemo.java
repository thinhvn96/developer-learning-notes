import java.util.*;

/** Run: java system-design/examples/SagaDemo.java  An orchestrated saga: local steps with compensations. */
public class SagaDemo {
    interface Step { String name(); void run(); void compensate(); }

    static Step step(String name, Runnable action, Runnable undo) {
        return new Step() {
            public String name() { return name; }
            public void run() { action.run(); }
            public void compensate() { undo.run(); }
        };
    }

    /** Orchestrator: runs steps in order; on failure compensates the completed steps in reverse order. */
    static void runSaga(List<Step> steps) {
        Deque<Step> done = new ArrayDeque<>();
        try {
            for (Step s : steps) { System.out.println("  do         " + s.name()); s.run(); done.push(s); }
            System.out.println("  saga completed");
        } catch (RuntimeException e) {
            System.out.println("  FAILED: " + e.getMessage() + " -> compensating");
            while (!done.isEmpty()) { Step s = done.pop(); System.out.println("  compensate " + s.name()); s.compensate(); }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- payment succeeds");
        runSaga(List.of(
            step("create order", () -> {}, () -> System.out.println("    order cancelled")),
            step("reserve stock", () -> {}, () -> System.out.println("    stock released")),
            step("charge payment", () -> {}, () -> System.out.println("    payment refunded"))));
        System.out.println("--- payment fails");
        runSaga(List.of(
            step("create order", () -> {}, () -> System.out.println("    order cancelled")),
            step("reserve stock", () -> {}, () -> System.out.println("    stock released")),
            step("charge payment", () -> { throw new IllegalStateException("card declined"); }, () -> {})));
    }
}
