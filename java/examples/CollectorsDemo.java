import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Run: java java/examples/CollectorsDemo.java */
public class CollectorsDemo {
    record Emp(String name, String dept, int salary) {}

    public static void main(String[] args) {
        List<Emp> emps = List.of(new Emp("ann", "dev", 5200), new Emp("bob", "dev", 4200),
                                 new Emp("cy", "ops", 4800), new Emp("dee", "ops", 4800));

        System.out.println("groupingBy      : " + emps.stream().collect(
                Collectors.groupingBy(Emp::dept, Collectors.mapping(Emp::name, Collectors.toList()))));
        System.out.println("sum by dept     : " + emps.stream().collect(
                Collectors.groupingBy(Emp::dept, Collectors.summingInt(Emp::salary))));
        System.out.println("partitioningBy : " + emps.stream().collect(
                Collectors.partitioningBy(e -> e.salary() >= 5000, Collectors.counting())));
        System.out.println("joining         : " + emps.stream().map(Emp::name).collect(Collectors.joining(", ", "[", "]")));

        try {
            emps.stream().collect(Collectors.toMap(Emp::salary, Emp::name));   // 4800 appears twice
        } catch (IllegalStateException e) { System.out.println("toMap duplicate: IllegalStateException"); }

        Map<Integer, String> merged = emps.stream().collect(
                Collectors.toMap(Emp::salary, Emp::name, (x, y) -> x + "+" + y));
        System.out.println("toMap w/ merge  : " + new java.util.TreeMap<>(merged));
    }
}
