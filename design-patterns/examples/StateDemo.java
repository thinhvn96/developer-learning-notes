/** Run: java design-patterns/examples/StateDemo.java  Behavior depends on the current state object; states trigger the transitions. */
public class StateDemo {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.publish(); doc.publish(); doc.publish();
        doc.publish();                                        // already published: no-op
        doc.reject();
    }
}
class Document {
    private State state = new Draft();
    void setState(State s) { System.out.println("  state -> " + s.getClass().getSimpleName()); state = s; }
    void publish() { state.publish(this); }
    void reject() { state.reject(this); }
}
interface State { void publish(Document d); void reject(Document d); }
class Draft implements State {
    public void publish(Document d) { System.out.println("draft: sending to moderation"); d.setState(new Moderation()); }
    public void reject(Document d) { System.out.println("draft: nothing to reject"); }
}
class Moderation implements State {
    public void publish(Document d) { System.out.println("moderation: approved, publishing"); d.setState(new Published()); }
    public void reject(Document d) { System.out.println("moderation: rejected, back to draft"); d.setState(new Draft()); }
}
class Published implements State {
    public void publish(Document d) { System.out.println("published: already public, ignoring"); }
    public void reject(Document d) { System.out.println("published: cannot reject a public document"); }
}
