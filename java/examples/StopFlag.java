/**
 * Run: java java/examples/StopFlag.java
 * Try removing `volatile` and run again. Without a happens-before edge the reader
 * thread is NOT guaranteed to ever see the update; the outcome depends on the JIT and hardware.
 */
public class StopFlag {
    static volatile boolean stop = false;

    public static void main(String[] args) throws Exception {
        Thread worker = new Thread(() -> {
            long spins = 0;
            while (!stop) spins++;
            System.out.println("worker saw stop after spinning");
        });
        worker.start();
        Thread.sleep(200);
        stop = true;      // volatile write happens-before every later volatile read of `stop`
        worker.join(2000);
        System.out.println(worker.isAlive() ? "worker still running (never saw the write)" : "worker finished");
        if (worker.isAlive()) System.exit(1);
    }
}
