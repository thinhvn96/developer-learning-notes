import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/** Run: java design-patterns/examples/PatternsInJdkDemo.java  Patterns you already use in the JDK. */
public class PatternsInJdkDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Singleton  Runtime.getRuntime() same instance : " + (Runtime.getRuntime() == Runtime.getRuntime()));
        System.out.println("Factory    List.of(..) class chosen by the JDK : " + List.of(1).getClass().getSimpleName());
        System.out.println("Flyweight  Integer.valueOf(100) == valueOf(100): " + (Integer.valueOf(100) == Integer.valueOf(100)));
        System.out.println("Builder    StringBuilder                       : " + new StringBuilder().append("x").append(1));
        String[] arr = {"a", "b"};
        List<String> adapted = Arrays.asList(arr); adapted.set(0, "z");
        System.out.println("Adapter    Arrays.asList write-through         : " + arr[0]);
        List<String> base = new ArrayList<>(List.of("a"));
        List<String> ro = Collections.unmodifiableList(base); base.add("b");
        System.out.println("Decorator  Collections.unmodifiableList        : " + ro);
        System.out.println("Decorator  BufferedReader(StringReader)        : " + new BufferedReader(new StringReader("hi")).readLine());
        List<String> words = new ArrayList<>(List.of("ccc", "a", "bb"));
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("Strategy   Comparator                          : " + words);
        Iterator<String> it = words.iterator();
        System.out.println("Iterator   Iterator.next()                     : " + it.next());
        Runnable cmd = () -> System.out.println("Command    Runnable (a request as an object)   : run");
        cmd.run();
        AbstractList<Integer> tm = new AbstractList<>() { public Integer get(int i) { return i; } public int size() { return 3; } };
        System.out.println("Template   AbstractList (get+size => the rest) : " + tm);
        Object p = java.lang.reflect.Proxy.newProxyInstance(Runnable.class.getClassLoader(), new Class<?>[]{Runnable.class}, (px, m, a) -> null);
        System.out.println("Proxy      java.lang.reflect.Proxy             : " + p.getClass().getSimpleName().startsWith("$Proxy"));
        try (SubmissionPublisher<Integer> pub = new SubmissionPublisher<>()) {
            System.out.println("Observer   Flow / SubmissionPublisher          : " + pub.getClass().getSimpleName());
        }
    }
}
