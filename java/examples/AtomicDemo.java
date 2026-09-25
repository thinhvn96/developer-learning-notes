import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/** Run: java java/examples/AtomicDemo.java  count++ on a volatile int loses updates; atomics and locks do not. */
public class AtomicDemo {
    static volatile int volatileCount = 0;
    static int lockedCount = 0;
    static final AtomicInteger atomicCount = new AtomicInteger();
    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        final int threads = 4, perThread = 200_000;
        Thread[] ts = new Thread[threads];
        for (int t = 0; t < threads; t++) {
            ts[t] = new Thread(() -> {
                for (int i = 0; i < perThread; i++) {
                    volatileCount++;                    // read-modify-write: NOT atomic
                    atomicCount.incrementAndGet();      // atomic (compare-and-set loop)
                    lock.lock();
                    try { lockedCount++; } finally { lock.unlock(); }
                }
            });
            ts[t].start();
        }
        for (Thread t : ts) t.join();
        System.out.println("expected       : " + threads * perThread);
        System.out.println("volatile int   : " + volatileCount + "  (lost updates: " + (threads * perThread - volatileCount) + ")");
        System.out.println("AtomicInteger  : " + atomicCount.get());
        System.out.println("ReentrantLock  : " + lockedCount);
    }
}
