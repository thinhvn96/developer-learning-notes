import java.util.*;

/** Run: java system-design/examples/ShardingDemo.java  How many keys move when you add a shard: hash mod N vs consistent hashing. */
public class ShardingDemo {
    static int modShard(String key, int n) { return Math.floorMod(key.hashCode(), n); }

    /** Consistent hashing ring with virtual nodes. */
    static class Ring {
        final TreeMap<Integer, Integer> ring = new TreeMap<>();
        Ring(int shards, int vnodes) { for (int s = 0; s < shards; s++) add(s, vnodes); }
        void add(int shard, int vnodes) { for (int v = 0; v < vnodes; v++) ring.put(mix(("shard-" + shard + "#" + v).hashCode()), shard); }
        int shardFor(String key) { var e = ring.ceilingEntry(mix(key.hashCode())); return (e != null ? e : ring.firstEntry()).getValue(); }
        static int mix(int h) { h ^= (h >>> 16); h *= 0x85ebca6b; h ^= (h >>> 13); h *= 0xc2b2ae35; h ^= (h >>> 16); return h; }
    }

    public static void main(String[] args) {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) keys.add("user-" + i);

        int moved = 0;
        for (String k : keys) if (modShard(k, 4) != modShard(k, 5)) moved++;
        System.out.printf("hash(key) mod N, 4 -> 5 shards : %.1f%% of keys move%n", 100.0 * moved / keys.size());

        Ring before = new Ring(4, 200), after = new Ring(4, 200); after.add(4, 200);
        moved = 0;
        for (String k : keys) if (before.shardFor(k) != after.shardFor(k)) moved++;
        System.out.printf("consistent hashing, 4 -> 5     : %.1f%% of keys move (ideal is 20%%)%n", 100.0 * moved / keys.size());

        int[] counts = new int[5];
        for (String k : keys) counts[after.shardFor(k)]++;
        System.out.println("keys per shard after adding one: " + Arrays.toString(counts));
    }
}
