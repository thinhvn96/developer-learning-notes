import java.util.*;

/** Run: java design-patterns/examples/MementoDemo.java  Snapshot and restore state without breaking encapsulation. */
public class MementoDemo {
    public static void main(String[] args) {
        TextEditor ed = new TextEditor();
        Deque<TextEditor.Snapshot> history = new ArrayDeque<>();     // the caretaker: stores snapshots but cannot read them
        ed.type("Hello"); history.push(ed.save());
        ed.type(", world"); history.push(ed.save());
        ed.type("!!!");
        System.out.println("now      : " + ed);
        ed.restore(history.pop()); System.out.println("restore 1: " + ed);
        ed.restore(history.pop()); System.out.println("restore 2: " + ed);
    }
}
class TextEditor {
    private StringBuilder text = new StringBuilder();
    void type(String s) { text.append(s); }
    Snapshot save() { return new Snapshot(text.toString()); }
    void restore(Snapshot s) { text = new StringBuilder(s.state); }
    public String toString() { return text.toString(); }
    static class Snapshot { private final String state; private Snapshot(String s) { state = s; } }   // opaque to the caretaker
}
