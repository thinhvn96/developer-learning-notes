import java.util.*;

/** Run: java oop/examples/CompositionVsInheritance.java  The fragile base class problem, and composition as the fix. */
public class CompositionVsInheritance {
    public static void main(String[] args) {
        CountingSetByInheritance a = new CountingSetByInheritance();
        a.addAll(List.of("x", "y", "z"));
        System.out.println("inheritance: added 3 elements, addCount = " + a.addCount + "   (expected 3)");

        CountingSetByComposition b = new CountingSetByComposition(new HashSet<>());
        b.addAll(List.of("x", "y", "z"));
        System.out.println("composition: added 3 elements, addCount = " + b.addCount + "   (expected 3)");
    }
}
/** Extends HashSet: relies on HashSet's internal choice that addAll() calls add() for each element. */
class CountingSetByInheritance extends HashSet<String> {
    int addCount = 0;
    @Override public boolean add(String s) { addCount++; return super.add(s); }
    @Override public boolean addAll(Collection<? extends String> c) { addCount += c.size(); return super.addAll(c); }
}
/** Has-a Set and forwards calls: independent of how the wrapped class is implemented internally. */
class CountingSetByComposition {
    private final Set<String> delegate; int addCount = 0;
    CountingSetByComposition(Set<String> d) { delegate = d; }
    boolean add(String s) { addCount++; return delegate.add(s); }
    boolean addAll(Collection<? extends String> c) { addCount += c.size(); return delegate.addAll(c); }
}
