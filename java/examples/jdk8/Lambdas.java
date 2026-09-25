import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/** JDK 8. Compile check: javac --release 8 Lambdas.java   Run: java java/examples/jdk8/Lambdas.java */
public class Lambdas {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ann", "bob", "cy", "dee");

        Predicate<String> shortName = s -> s.length() <= 3;      // Predicate<T>
        Function<String, Integer> length = String::length;        // method reference

        names.stream().filter(shortName).map(length).forEach(System.out::println);

        // A lambda may read a local variable only if it is final or effectively final.
        int base = 10;                                            // never reassigned: effectively final
        Function<Integer, Integer> plusBase = x -> x + base;
        System.out.println(plusBase.apply(5));
        // base = 11;   // uncommenting this line makes the lambda above a compile error
    }
}
