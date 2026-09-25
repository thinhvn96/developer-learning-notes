import java.util.ArrayList;
import java.util.List;

/** Run: java java/examples/GenericsDemo.java */
public class GenericsDemo {
    // "in" parameter: producer of Numbers => upper bounded wildcard (extends)
    static double sum(List<? extends Number> in) {
        double s = 0;
        for (Number n : in) s += n.doubleValue();
        return s;
    }

    // "out" parameter: consumer of Integers => lower bounded wildcard (super)
    static void fill(List<? super Integer> out) {
        for (int i = 1; i <= 3; i++) out.add(i);
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3));
        // List<Number> nums = ints;   // compile error: List<Integer> is not a List<Number>
        System.out.println("sum of ints    : " + sum(ints));

        List<Number> nums = new ArrayList<>();
        List<Object> objs = new ArrayList<>();
        fill(nums); fill(objs);
        System.out.println("filled Number  : " + nums);
        System.out.println("filled Object  : " + objs);

        // Type erasure: the type argument is gone at runtime.
        List<String> strings = new ArrayList<>();
        System.out.println("same runtime class: " + (strings.getClass() == ints.getClass()));
        // if (strings instanceof List<String>) {}   // compile error: not reifiable
    }
}
