import java.util.*;
import java.util.concurrent.*;

/** Lesson 0039. Run: java java/examples/collections/ConcurrentCollections.java */
public class ConcurrentCollections {
    public static void main(String[] args) throws Exception {
        // 1. Plain ArrayList shared by 4 threads: lost updates or an exception.
        List<Integer> unsafe = new ArrayList<>();
        String outcome = run4(() -> { for (int i = 0; i < 10_000; i++) unsafe.add(i); });
        System.out.println("ArrayList, 4 threads x 10,000 adds   : size=" + unsafe.size() + outcome);

        List<Integer> safe = Collections.synchronizedList(new ArrayList<>());
        run4(() -> { for (int i = 0; i < 10_000; i++) safe.add(i); });
        System.out.println("synchronizedList, same work          : size=" + safe.size());

        // 2. CopyOnWriteArrayList: snapshot iterator, no CME, does not see its own adds.
        List<String> listeners = new CopyOnWriteArrayList<>(List.of("a", "b"));
        int seen = 0;
        for (String l : listeners) { listeners.add(l + "2"); seen++; }
        System.out.println("CopyOnWriteArrayList iterate+add     : saw " + seen + ", list now " + listeners);

        // 3. Bounded BlockingQueue: producer blocks when full (backpressure), poison pill to stop.
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        System.out.println("offer on full queue                  : " + q.offer(1) + " " + q.offer(2) + " " + q.offer(3));
        q.clear();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> consumer = pool.submit(() -> {
            int sum = 0;
            for (int x; (x = q.take()) != -1; ) sum += x;
            return sum;
        });
        pool.submit(() -> { for (int i = 1; i <= 100; i++) q.put(i); q.put(-1); return null; });
        System.out.println("producer/consumer sum 1..100         : " + consumer.get(5, TimeUnit.SECONDS));
        pool.shutdown();

        // 4. ConcurrentSkipListMap: sorted AND concurrent.
        ConcurrentSkipListMap<Integer, String> prices = new ConcurrentSkipListMap<>();
        run4(() -> { for (int i = 0; i < 100; i++) prices.put(ThreadLocalRandom.current().nextInt(1000), "x"); });
        System.out.println("ConcurrentSkipListMap first/last key : " + prices.firstKey() + " / " + prices.lastKey()
                + "  ceilingKey(500)=" + prices.ceilingKey(500));
    }

    static String run4(Runnable r) throws InterruptedException {
        List<Thread> ts = new ArrayList<>();
        Throwable[] err = {null};
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(() -> { try { r.run(); } catch (Throwable e) { err[0] = e; } });
            ts.add(t); t.start();
        }
        for (Thread t : ts) t.join();
        return err[0] == null ? "" : "  (+ " + err[0].getClass().getSimpleName() + ")";
    }
}
