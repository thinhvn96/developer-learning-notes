import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/** Run: java java/examples/StreamAndOptional.java */
public class StreamAndOptional {
    static String expensive() {
        System.out.println("  expensive() called");
        return "default";
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3);

        System.out.println("1. Intermediate ops are lazy (no terminal op, no output):");
        data.stream().peek(x -> System.out.println("  saw " + x)).map(x -> x * 2);

        System.out.println("2. A terminal op triggers the pipeline:");
        data.stream().peek(x -> System.out.println("  saw " + x)).map(x -> x * 2).toList();

        System.out.println("3. A stream is consumed once:");
        Stream<Integer> s = data.stream();
        s.count();
        try {
            s.count();
        } catch (IllegalStateException e) {
            System.out.println("  IllegalStateException: " + e.getMessage());
        }

        System.out.println("4. orElse evaluates its argument even when a value is present:");
        Optional.of("present").orElse(expensive());
        System.out.println("5. orElseGet only calls the supplier when empty:");
        Optional.of("present").orElseGet(StreamAndOptional::expensive);
        System.out.println("  (nothing printed above)");
    }
}
