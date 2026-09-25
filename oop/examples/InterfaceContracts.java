import java.util.*;

/** Run: java oop/examples/InterfaceContracts.java  Code against the contract; swap implementations without touching the caller. */
public class InterfaceContracts {
    static void checkout(PaymentMethod m, int amount) { System.out.println(m.pay(amount)); }   // depends on the contract only

    public static void main(String[] args) {
        checkout(new CardPayment("4242"), 100);
        checkout(new WalletPayment(50), 100);
        checkout(amount -> "gift card paid " + amount, 30);       // a lambda is an implementation of a one-method interface
        System.out.println(PaymentMethod.describe());              // static interface method
    }
}
interface PaymentMethod {
    String pay(int amount);
    static String describe() { return "PaymentMethod: pay(int) -> receipt"; }
}
class CardPayment implements PaymentMethod {
    private final String last4; CardPayment(String l) { last4 = l; }
    public String pay(int a) { return "card ****" + last4 + " charged " + a; }
}
class WalletPayment implements PaymentMethod {
    private int balance; WalletPayment(int b) { balance = b; }
    public String pay(int a) { if (a > balance) return "wallet declined " + a; balance -= a; return "wallet paid " + a; }
}
