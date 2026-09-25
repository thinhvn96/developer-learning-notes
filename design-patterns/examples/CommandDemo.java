import java.util.*;

/** Run: java design-patterns/examples/CommandDemo.java  Requests as objects: queue them, log them, undo them. */
public class CommandDemo {
    public static void main(String[] args) {
        Editor ed = new Editor();
        Deque<Command> history = new ArrayDeque<>();
        for (Command c : List.of(new Append(ed, "Hello"), new Append(ed, ", world"), new Upper(ed))) { c.execute(); history.push(c); System.out.println(c.name() + " -> \"" + ed.text + "\""); }
        while (!history.isEmpty()) { Command c = history.pop(); c.undo(); System.out.println("undo " + c.name() + " -> \"" + ed.text + "\""); }
        Runnable r = () -> System.out.println("a Runnable is a one-method Command");
        r.run();
    }
}
class Editor { String text = ""; }
interface Command { void execute(); void undo(); String name(); }
class Append implements Command {
    private final Editor ed; private final String s;
    Append(Editor e, String s) { ed = e; this.s = s; }
    public void execute() { ed.text += s; } public void undo() { ed.text = ed.text.substring(0, ed.text.length() - s.length()); } public String name() { return "append(" + s + ")"; }
}
class Upper implements Command {
    private final Editor ed; private String before;
    Upper(Editor e) { ed = e; }
    public void execute() { before = ed.text; ed.text = ed.text.toUpperCase(); } public void undo() { ed.text = before; } public String name() { return "upper"; }
}
