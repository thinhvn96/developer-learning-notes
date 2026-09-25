public class Hello {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Hello from a container");
        System.out.println("processors seen by JVM: " + rt.availableProcessors());
        System.out.println("max heap (MB) seen by JVM: " + rt.maxMemory() / (1024 * 1024));
    }
}
