import java.util.concurrent.*;

/** Run: java system-design/examples/BulkheadDemo.java  One slow dependency vs a shared pool and vs separate pools. */
public class BulkheadDemo {
    static long timeCallsToHealthyService(ExecutorService poolForHealthy, ExecutorService poolForSlow) throws Exception {
        // 4 calls to the SLOW service (2 s each) are submitted first, then 4 calls to the HEALTHY service (10 ms each).
        for (int i = 0; i < 4; i++) poolForSlow.submit(() -> { Thread.sleep(2000); return "slow"; });
        long start = System.nanoTime();
        Future<?>[] fs = new Future<?>[4];
        for (int i = 0; i < 4; i++) fs[i] = poolForHealthy.submit(() -> { Thread.sleep(10); return "healthy"; });
        for (Future<?> f : fs) f.get();
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService shared = Executors.newFixedThreadPool(4);
        long t1 = timeCallsToHealthyService(shared, shared);
        shared.shutdownNow();
        System.out.println("shared pool of 4 threads     : healthy calls took " + t1 + " ms (stuck behind the slow service)");

        ExecutorService slowPool = Executors.newFixedThreadPool(2), healthyPool = Executors.newFixedThreadPool(2);
        long t2 = timeCallsToHealthyService(healthyPool, slowPool);
        slowPool.shutdownNow(); healthyPool.shutdownNow();
        System.out.println("separate pools (bulkheads)   : healthy calls took " + t2 + " ms");
    }
}
