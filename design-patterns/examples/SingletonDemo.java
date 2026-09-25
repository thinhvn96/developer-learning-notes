import java.util.*;
import java.util.concurrent.*;

/** Run: java design-patterns/examples/SingletonDemo.java  Three ways to get one instance, and the testing cost of global state. */
public class SingletonDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("enum singleton same instance      : " + (Config.INSTANCE == Config.INSTANCE));
        System.out.println("holder singleton same instance    : " + (Holder.get() == Holder.get()));
        System.out.println("JDK Runtime.getRuntime() same     : " + (Runtime.getRuntime() == Runtime.getRuntime()));

        Set<Object> seen = ConcurrentHashMap.newKeySet();
        ExecutorService pool = Executors.newFixedThreadPool(8);
        List<Future<?>> fs = new ArrayList<>();
        for (int i = 0; i < 8; i++) fs.add(pool.submit(() -> seen.add(Holder.get())));
        for (Future<?> f : fs) f.get(); pool.shutdown();
        System.out.println("distinct holder instances across 8 threads: " + seen.size());

        // The testing cost: global mutable state leaks between tests.
        Config.INSTANCE.setMode("test-A");
        System.out.println("test B sees leftover state         : " + Config.INSTANCE.mode());
    }
}
enum Config {                                            // simplest thread-safe singleton in Java: initialization is guaranteed once by the JVM
    INSTANCE;
    private String mode = "default";
    String mode() { return mode; } void setMode(String m) { mode = m; }
}
class Holder {                                           // lazy holder idiom: class initialization is thread-safe
    private Holder() {}
    private static class Lazy { static final Holder INSTANCE = new Holder(); }
    static Holder get() { return Lazy.INSTANCE; }
}
