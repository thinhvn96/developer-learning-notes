import java.io.IOException;

/** Run: java java/examples/ExceptionsDemo.java */
public class ExceptionsDemo {
    static class Res implements AutoCloseable {
        final String name; final boolean failOnClose;
        Res(String name, boolean failOnClose) { this.name = name; this.failOnClose = failOnClose; System.out.println("open  " + name); }
        @Override public void close() throws IOException {
            System.out.println("close " + name);
            if (failOnClose) throw new IOException("close failed: " + name);
        }
    }

    // Checked exception: callers must catch or declare it.
    static void mayFail() throws IOException { throw new IOException("checked"); }

    public static void main(String[] args) {
        System.out.println("--- close order is the reverse of opening");
        try (Res first = new Res("first", false); Res second = new Res("second", false)) {
            System.out.println("body");
        } catch (IOException e) { System.out.println("unexpected"); }

        System.out.println("--- an exception from close() is suppressed when the body already threw");
        try (Res r = new Res("r", true)) {
            throw new IllegalStateException("body failed");
        } catch (Exception e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable s : e.getSuppressed()) System.out.println("suppressed: " + s.getMessage());
        }

        System.out.println("--- unchecked exceptions need no catch or declaration");
        try { Object o = "s"; Integer i = (Integer) o; }
        catch (RuntimeException e) { System.out.println(e.getClass().getSimpleName()); }

        try { mayFail(); } catch (IOException e) { System.out.println("caught checked: " + e.getMessage()); }
    }
}
