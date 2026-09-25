import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/** Run: java system-design/examples/LoadLevelingDemo.java  A queue absorbs a burst; the service keeps a steady pace. */
public class LoadLevelingDemo {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        AtomicInteger inFlight = new AtomicInteger(), maxInFlight = new AtomicInteger(), processed = new AtomicInteger();

        // The "service": 2 workers, each task takes 100 ms => at most 20 tasks per second.
        ExecutorService workers = Executors.newFixedThreadPool(2);
        for (int w = 0; w < 2; w++) workers.submit(() -> {
            try {
                while (true) {
                    queue.take();
                    int now = inFlight.incrementAndGet(); maxInFlight.accumulateAndGet(now, Math::max);
                    Thread.sleep(100);
                    inFlight.decrementAndGet(); processed.incrementAndGet();
                }
            } catch (InterruptedException ignored) {}
        });

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) queue.put(i);           // a burst of 100 tasks arrives at once
        System.out.println("burst of 100 accepted in " + (System.currentTimeMillis() - start) + " ms; queue length now ~" + queue.size());
        while (processed.get() < 100) Thread.sleep(50);
        System.out.println("all processed after " + (System.currentTimeMillis() - start) + " ms; max concurrent work at the service = " + maxInFlight.get());
        workers.shutdownNow();
    }
}
