/** Run: java design-patterns/examples/FactoryMethodDemo.java  The creator decides WHICH product; the client only uses the interface. */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        for (Dialog d : new Dialog[] { new WindowsDialog(), new WebDialog() }) d.render();
        // Static factory methods are the everyday cousin: the caller gets an interface type, the factory picks the class.
        java.util.List<Integer> small = java.util.List.of(1, 2);
        System.out.println("List.of(...) returns a List; concrete class chosen by the JDK: " + small.getClass().getSimpleName());
    }
}
interface Button { String draw(); }
class WinButton implements Button { public String draw() { return "[Windows button]"; } }
class HtmlButton implements Button { public String draw() { return "<button>"; } }
abstract class Dialog {
    abstract Button createButton();                    // the factory method: subclasses choose the concrete product
    void render() { System.out.println(getClass().getSimpleName() + " renders " + createButton().draw()); }   // uses only the interface
}
class WindowsDialog extends Dialog { Button createButton() { return new WinButton(); } }
class WebDialog extends Dialog { Button createButton() { return new HtmlButton(); } }
