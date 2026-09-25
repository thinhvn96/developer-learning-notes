import java.util.function.Supplier;

/** Run: java system-design/examples/CircuitBreakerDemo.java  A minimal Closed / Open / Half-Open state machine. */
public class CircuitBreakerDemo {
    enum State { CLOSED, OPEN, HALF_OPEN }

    static class CircuitBreaker {
        private State state = State.CLOSED;
        private int failures = 0;
        private final int threshold; private final long openMillis;
        private long openedAt;
        CircuitBreaker(int threshold, long openMillis) { this.threshold = threshold; this.openMillis = openMillis; }

        <T> T call(Supplier<T> op, T fallback) {
            if (state == State.OPEN) {
                if (System.currentTimeMillis() - openedAt >= openMillis) { state = State.HALF_OPEN; }
                else return fallback;                         // fail fast, do not touch the service
            }
            try {
                T result = op.get();
                if (state == State.HALF_OPEN) { state = State.CLOSED; }   // trial call succeeded
                failures = 0;
                return result;
            } catch (RuntimeException e) {
                failures++;
                if (state == State.HALF_OPEN || failures >= threshold) { state = State.OPEN; openedAt = System.currentTimeMillis(); }
                return fallback;
            }
        }
        State state() { return state; }
    }

    static int realCalls = 0;
    static boolean serviceUp = false;
    static String service() { realCalls++; if (!serviceUp) throw new IllegalStateException("down"); return "ok"; }

    public static void main(String[] args) throws Exception {
        CircuitBreaker cb = new CircuitBreaker(3, 300);
        for (int i = 1; i <= 8; i++) {
            String r = cb.call(CircuitBreakerDemo::service, "fallback");
            System.out.printf("call %d -> %-8s state=%-9s real calls to service so far=%d%n", i, r, cb.state(), realCalls);
        }
        System.out.println("-- service recovers, wait for the open timeout");
        serviceUp = true; Thread.sleep(350);
        for (int i = 9; i <= 11; i++) {
            String r = cb.call(CircuitBreakerDemo::service, "fallback");
            System.out.printf("call %d -> %-8s state=%-9s real calls to service so far=%d%n", i, r, cb.state(), realCalls);
        }
    }
}
