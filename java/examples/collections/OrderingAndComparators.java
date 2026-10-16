import java.math.BigDecimal;
import java.util.*;

/** Lesson 0031. Run: java java/examples/collections/OrderingAndComparators.java */
public class OrderingAndComparators {
    record Employee(String dept, String name, int salary) {}

    public static void main(String[] args) {
        // 1. compareTo inconsistent with equals: BigDecimal.
        BigDecimal a = new BigDecimal("4.0"), b = new BigDecimal("4.00");
        System.out.println("4.0 equals 4.00?     " + a.equals(b) + "   compareTo == 0? " + (a.compareTo(b) == 0));
        System.out.println("HashSet size: " + new HashSet<>(List.of(a, b)).size()
                + "   TreeSet size: " + new TreeSet<>(List.of(a, b)).size());

        // 2. A comparator that only looks at one field silently drops "duplicates" in a TreeSet.
        List<Employee> staff = List.of(new Employee("eng", "Lan", 3000), new Employee("eng", "Minh", 3000),
                new Employee("ops", "Hoa", 2500), new Employee("eng", "An", 4000));
        Set<Employee> bySalary = new TreeSet<>(Comparator.comparingInt(Employee::salary));
        bySalary.addAll(staff);
        System.out.println("TreeSet by salary only keeps " + bySalary.size() + " of " + staff.size() + ": "
                + bySalary.stream().map(Employee::name).toList());

        // 3. Chained comparator: dept asc, salary desc, name asc. Sorting is stable.
        List<Employee> sorted = new ArrayList<>(staff);
        sorted.sort(Comparator.comparing(Employee::dept)
                .thenComparing(Employee::salary, Comparator.reverseOrder())
                .thenComparing(Employee::name));
        sorted.forEach(e -> System.out.println("  " + e));

        // 4. The subtraction comparator overflows.
        Comparator<Integer> broken = (x, y) -> x - y;
        System.out.println("broken compare(MIN_VALUE, 1) = " + broken.compare(Integer.MIN_VALUE, 1)
                + "  (positive: claims MIN_VALUE > 1)");
        System.out.println("Integer.compare(MIN_VALUE, 1) = " + Integer.compare(Integer.MIN_VALUE, 1));

        // 5. Nulls: natural order throws, nullsFirst handles them.
        List<String> withNull = new ArrayList<>(Arrays.asList("b", null, "a"));
        try { withNull.sort(Comparator.naturalOrder()); }
        catch (NullPointerException e) { System.out.println("naturalOrder with null -> NullPointerException"); }
        withNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("nullsFirst -> " + withNull);
    }
}
