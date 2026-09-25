/** Run: java oop/examples/DipDemo.java  High-level policy and low-level detail both depend on an abstraction. */
public class DipDemo {
    public static void main(String[] args) {
        Notifier email = new EmailSender(), sms = new SmsSender();
        new AlertService(email).raise("disk full");                       // wiring happens at the edge (main)
        new AlertService(sms).raise("disk full");
        new AlertService(msg -> System.out.println("[test double] " + msg)).raise("disk full");
    }
}
interface Notifier { void send(String message); }                          // owned by the high-level module
class AlertService {                                                       // high-level policy: no knowledge of email or sms
    private final Notifier notifier;
    AlertService(Notifier n) { notifier = n; }
    void raise(String problem) { notifier.send("ALERT: " + problem); }
}
class EmailSender implements Notifier { public void send(String m) { System.out.println("email -> " + m); } }
class SmsSender implements Notifier { public void send(String m) { System.out.println("sms   -> " + m); } }
