import java.util.*;

/** Run: java oop/examples/ImmutabilityDemo.java  Mutable leak vs defensive copies vs a record. */
public class ImmutabilityDemo {
    public static void main(String[] args) {
        List<String> members = new ArrayList<>(List.of("ann"));
        MutableTeam m = new MutableTeam(members);
        members.add("intruder");
        System.out.println("MutableTeam after outside change   : " + m.members());

        List<String> members2 = new ArrayList<>(List.of("ann"));
        ImmutableTeam i = new ImmutableTeam(members2);
        members2.add("intruder");
        System.out.println("ImmutableTeam after outside change : " + i.members());
        try { i.members().add("x"); } catch (UnsupportedOperationException e) { System.out.println("cannot modify the exposed list"); }

        Point p = new Point(1, 2);
        System.out.println(p + " equals another Point(1,2): " + p.equals(new Point(1, 2)) + ", moved copy: " + p.withX(9));
    }
}
class MutableTeam {
    private final List<String> members;                      // final reference, mutable object, shared with the caller
    MutableTeam(List<String> m) { members = m; }
    List<String> members() { return members; }
}
final class ImmutableTeam {                                    // final class, final field, defensive copies
    private final List<String> members;
    ImmutableTeam(List<String> m) { members = List.copyOf(m); }
    List<String> members() { return members; }
}
record Point(int x, int y) { Point withX(int nx) { return new Point(nx, y); } }
