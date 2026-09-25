import java.util.Random;

/** Run: java system-design/examples/RetryDemo.java */
public class RetryDemo {
    static final Random rnd = new Random(42);

    /** A flaky dependency: fails the first `failures` calls, then succeeds. */
    static class Flaky {
        int calls = 0; final int failures;
        Flaky(int failures) { this.failures = failures; }
        String call() { if (++calls <= failures) throw new IllegalStateException("transient"); return "ok"; }
    }

    static String callWithRetry(Flaky svc, int maxAttempts, long baseMillis) throws InterruptedException {
        for (int attempt = 1; ; attempt++) {
            try {
                return svc.call();
            } catch (IllegalStateException e) {
                if (attempt == maxAttempts) throw e;                   // give up: cap the attempts
                long cap = baseMillis << (attempt - 1);                // exponential growth
                long delay = (long) (rnd.nextDouble() * cap);          // "full jitter": random in [0, cap)
                System.out.println("attempt " + attempt + " failed; sleeping " + delay + " ms (cap " + cap + ")");
                Thread.sleep(delay);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Flaky svc = new Flaky(3);
        System.out.println("result: " + callWithRetry(svc, 5, 100) + " after " + svc.calls + " calls");
        try {
            callWithRetry(new Flaky(10), 3, 100);
        } catch (IllegalStateException e) {
            System.out.println("gave up after 3 attempts: " + e.getMessage());
        }
    }
}
