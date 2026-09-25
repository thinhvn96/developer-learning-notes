import java.util.*;

/** Run: java design-patterns/examples/CompositeDemo.java  Treat a single item and a group of items uniformly. */
public class CompositeDemo {
    public static void main(String[] args) {
        Node tree = new Folder("root",
            new FileNode("a.txt", 10),
            new Folder("src", new FileNode("Main.java", 40), new FileNode("Util.java", 25)),
            new Folder("empty"));
        System.out.println("total size = " + tree.size());
        tree.print("");
    }
}
interface Node { int size(); void print(String indent); }
class FileNode implements Node {
    private final String name; private final int size;
    FileNode(String n, int s) { name = n; size = s; }
    public int size() { return size; }
    public void print(String indent) { System.out.println(indent + name + " (" + size + ")"); }
}
class Folder implements Node {
    private final String name; private final List<Node> children = new ArrayList<>();
    Folder(String n, Node... kids) { name = n; children.addAll(Arrays.asList(kids)); }
    public int size() { return children.stream().mapToInt(Node::size).sum(); }   // recursion through the same interface
    public void print(String indent) { System.out.println(indent + name + "/ (" + size() + ")"); children.forEach(c -> c.print(indent + "  ")); }
}
