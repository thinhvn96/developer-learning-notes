import java.util.*;

/** Lesson 0034. Run: java java/examples/collections/NavigableMaps.java */
public class NavigableMaps {
    public static void main(String[] args) {
        // Shipping fee by order total: the tier is the greatest threshold <= total.
        NavigableMap<Integer, Integer> feeFrom = new TreeMap<>(Map.of(0, 30_000, 200_000, 15_000, 500_000, 0));
        for (int total : List.of(50_000, 200_000, 499_999, 1_200_000))
            System.out.printf("total %,9d -> fee %,6d%n", total, feeFrom.floorEntry(total).getValue());

        // Time series: events keyed by minute.
        TreeMap<Integer, String> events = new TreeMap<>();
        for (int m : List.of(5, 12, 20, 33, 47, 58)) events.put(m, "e" + m);
        System.out.println("first at/after 21: " + events.ceilingEntry(21));
        System.out.println("last before 20   : " + events.lowerEntry(20));
        SortedMap<Integer, String> window = events.subMap(10, 40);   // [10, 40)
        System.out.println("subMap [10,40)   : " + window);
        events.put(15, "late");                                     // views are live
        System.out.println("after put(15)    : " + window);
        System.out.println("descending       : " + events.descendingMap().keySet());
        System.out.println("pollFirstEntry   : " + events.pollFirstEntry() + " -> " + events.keySet());

        // Leaderboard: highest score first; ties need a tie-breaker or players vanish.
        record Player(String name, int score) {}
        var board = new TreeSet<Player>(Comparator.comparingInt(Player::score).reversed().thenComparing(Player::name));
        board.addAll(List.of(new Player("lan", 90), new Player("an", 95), new Player("minh", 90)));
        System.out.println("leaderboard      : " + board.stream().map(p -> p.name() + "=" + p.score()).toList());
        try { new TreeMap<String, Integer>().put(null, 1); }
        catch (NullPointerException e) { System.out.println("TreeMap null key : NullPointerException"); }
    }
}
