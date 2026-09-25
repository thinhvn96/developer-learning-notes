import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;

/** Run: java java/examples/VirtualThreadsDemo.java  (needs Java 21+) */
public class VirtualThreadsDemo {
    public static void main(String[] args) {
        Instant start = Instant.now();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1)); // blocking: the virtual thread unmounts
                    return null;
                });
            }
        } // close() waits for all tasks
        System.out.println("10,000 one-second tasks finished in "
                + Duration.between(start, Instant.now()).toMillis() + " ms");
    }
}
