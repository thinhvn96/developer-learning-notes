import java.util.concurrent.*;

/** Run: java java/examples/PoolDemo.java  Shows core/max/queue behaviour and rejection policies. */
public class PoolDemo {
    static void run(RejectedExecutionHandler policy, String label) throws Exception {
        CountDownLatch release = new CountDownLatch(1);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), policy);
        System.out.println("=== " + label + " (core 2, max 4, queue 2)");
        for (int i = 1; i <= 7; i++) {
            final int id = i;
            try {
                pool.execute(() -> {
                    try { release.await(); } catch (InterruptedException ignored) {}
                    System.out.println("  task " + id + " ran on " + Thread.currentThread().getName());
                });
                System.out.println("task " + i + ": accepted  pool=" + pool.getPoolSize() + " queue=" + pool.getQueue().size());
            } catch (RejectedExecutionException e) {
                System.out.println("task " + i + ": REJECTED (RejectedExecutionException)");
            }
        }
        release.countDown();
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        run(new ThreadPoolExecutor.AbortPolicy(), "AbortPolicy");
    }
}
