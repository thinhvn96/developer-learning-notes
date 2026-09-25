/** Run: java design-patterns/examples/AbstractFactoryDemo.java  A factory of FAMILIES: products from one factory always match. */
public class AbstractFactoryDemo {
    static void buildUi(GuiFactory f) { System.out.println(f.button().draw() + " + " + f.checkbox().draw()); }
    public static void main(String[] args) {
        buildUi(new DarkFactory());
        buildUi(new LightFactory());
        // Mixing families (a dark button with a light checkbox) is impossible through the factory interface.
    }
}
interface Btn { String draw(); }
interface Chk { String draw(); }
interface GuiFactory { Btn button(); Chk checkbox(); }
class DarkFactory implements GuiFactory {
    public Btn button() { return () -> "dark-button"; }
    public Chk checkbox() { return () -> "dark-checkbox"; }
}
class LightFactory implements GuiFactory {
    public Btn button() { return () -> "light-button"; }
    public Chk checkbox() { return () -> "light-checkbox"; }
}
