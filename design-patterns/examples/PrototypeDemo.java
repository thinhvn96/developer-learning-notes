import java.util.*;

/** Run: java design-patterns/examples/PrototypeDemo.java  Copy a configured object instead of rebuilding it; beware shallow copies. */
public class PrototypeDemo {
    public static void main(String[] args) {
        Enemy template = new Enemy("orc", 100, new ArrayList<>(List.of("club")));
        Enemy shallow = template.shallowCopy(), deep = template.deepCopy();
        shallow.name = "orc-2"; deep.name = "orc-3";
        template.items.add("shield");                                 // change the template's list after copying
        System.out.println("template : " + template);
        System.out.println("shallow  : " + shallow + "   <- shares the SAME list object");
        System.out.println("deep     : " + deep + "   <- has its own list");
    }
}
class Enemy {
    String name; int hp; List<String> items;
    Enemy(String n, int hp, List<String> items) { name = n; this.hp = hp; this.items = items; }
    Enemy shallowCopy() { return new Enemy(name, hp, items); }                     // copies the reference
    Enemy deepCopy() { return new Enemy(name, hp, new ArrayList<>(items)); }       // copies the contents
    public String toString() { return name + "(hp=" + hp + ", items=" + items + ")"; }
}
