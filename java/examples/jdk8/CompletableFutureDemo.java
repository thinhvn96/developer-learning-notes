import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/** JDK 8. Compile check: javac --release 8 CompletableFutureDemo.java */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> ok = CompletableFuture
                .supplyAsync(() -> "hello")           // runs on ForkJoinPool.commonPool() by default
                .thenApply(String::toUpperCase);
        System.out.println(ok.join());

        CompletableFuture<Integer> failing = CompletableFuture.supplyAsync(() -> {
            if (true) throw new IllegalStateException("boom");
            return 1;
        });
        System.out.println("recovered: " + failing.exceptionally(ex -> -1).join());

        try { failing.join(); }
        catch (CompletionException e) { System.out.println("join() throws CompletionException, cause: " + e.getCause()); }
        try { failing.get(); }
        catch (ExecutionException e) { System.out.println("get()  throws ExecutionException,  cause: " + e.getCause()); }
    }
}
