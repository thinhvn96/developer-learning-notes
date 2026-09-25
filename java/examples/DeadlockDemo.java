import java.lang.management.ManagementFactory;
import java.util.concurrent.CountDownLatch;

/** Run: java java/examples/DeadlockDemo.java  Creates a lock-ordering deadlock, detects it, then shows the ordered fix. */
public class DeadlockDemo {
    static final Object A = new Object(), B = new Object();

    static Thread worker(String name, Object first, Object second, CountDownLatch bothHoldFirst) {
        Thread t = new Thread(() -> {
            synchronized (first) {
                bothHoldFirst.countDown();
                try { bothHoldFirst.await(); } catch (InterruptedException ignored) {}
                synchronized (second) { System.out.println(name + " got both locks"); }
            }
        }, name);
        t.setDaemon(true);
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--- opposite lock order (A then B, B then A)");
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = worker("T1", A, B, latch), t2 = worker("T2", B, A, latch);
        t1.start(); t2.start();
        Thread.sleep(500);
        long[] ids = ManagementFactory.getThreadMXBean().findDeadlockedThreads();
        System.out.println("deadlocked threads detected: " + (ids == null ? 0 : ids.length));

        System.out.println("--- same lock order everywhere (A then B)");
        CountDownLatch none = new CountDownLatch(0);
        // A and B are still held by T1/T2 above (stuck daemon threads), so use fresh locks for the fix demo:
        Object C = new Object(), D = new Object();
        Thread t5 = worker("T5", C, D, none), t6 = worker("T6", C, D, none);
        t5.start(); t6.start(); t5.join(2000); t6.join(2000);
    }
}
