import java.util.ArrayList;
import java.util.List;

/** Run: java java/examples/RecordDemo.java */
public class RecordDemo {
    record Point(int x, int y) {}

    record Team(String name, List<String> members) {
        // Compact constructor: validate and defensively copy.
        Team {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
            members = List.copyOf(members);
        }
    }

    record LeakyTeam(String name, List<String> members) {}

    public static void main(String[] args) {
        System.out.println(new Point(1, 2));                          // toString from components
        System.out.println(new Point(1, 2).equals(new Point(1, 2))); // equals from components
        System.out.println(new Point(1, 2).hashCode() == new Point(1, 2).hashCode());

        // Shallow immutability: the field is final, the list it points to is not.
        List<String> shared = new ArrayList<>(List.of("ann"));
        LeakyTeam leaky = new LeakyTeam("a", shared);
        shared.add("bob");
        System.out.println("LeakyTeam sees outside change: " + leaky.members());

        List<String> shared2 = new ArrayList<>(List.of("ann"));
        Team safe = new Team("a", shared2);
        shared2.add("bob");
        System.out.println("Team (copyOf) is protected:    " + safe.members());
    }
}
