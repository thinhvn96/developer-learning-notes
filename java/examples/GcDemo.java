/**
 * Run: java -Xmx64m -Xlog:gc java/examples/GcDemo.java
 * Then try: java -XX:+UseSerialGC -Xmx64m -Xlog:gc java/examples/GcDemo.java
 */
public class GcDemo {
    static Object sink;

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("max heap (MB): " + rt.maxMemory() / (1024 * 1024));
        for (int i = 0; i < 2_000_000; i++) {
            sink = new byte[1024]; // short-lived garbage: nothing keeps old arrays alive
        }
        System.out.println("done");
    }
}
