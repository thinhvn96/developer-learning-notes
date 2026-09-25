import java.lang.reflect.*;
import java.util.*;

/** Run: java design-patterns/examples/ProxyDemo.java  A stand-in with the same interface: lazy, logging, and a JDK dynamic proxy. */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("--- virtual (lazy) proxy");
        Image img = new LazyImage("big.png");
        System.out.println("proxy created, nothing loaded yet");
        img.show(); img.show();

        System.out.println("--- JDK dynamic proxy adding logging to ANY interface");
        Service real = new RealService();
        Service logged = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), new Class<?>[] { Service.class },
            (proxy, method, a) -> { System.out.println("  -> calling " + method.getName() + Arrays.toString(a)); Object r = method.invoke(real, a); System.out.println("  <- returned " + r); return r; });
        logged.compute(20, 22);
        System.out.println("proxy class name starts with: " + logged.getClass().getSimpleName().substring(0, 6));
    }
}
interface Image { void show(); }
class RealImage implements Image { RealImage(String f) { System.out.println("  loading " + f + " from disk (expensive)"); } public void show() { System.out.println("  showing image"); } }
class LazyImage implements Image {
    private final String file; private RealImage real;
    LazyImage(String f) { file = f; }
    public void show() { if (real == null) real = new RealImage(file); real.show(); }   // create on first use
}
interface Service { int compute(int a, int b); }
class RealService implements Service { public int compute(int a, int b) { return a + b; } }
