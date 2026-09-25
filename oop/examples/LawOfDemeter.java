/** Run: java oop/examples/LawOfDemeter.java  "Only talk to your immediate friends." */
public class LawOfDemeter {
    public static void main(String[] args) {
        Customer c = new Customer(new Wallet(100));
        // Violation: reaches through customer -> wallet -> money. The caller now knows the internal structure.
        c.getWallet().setMoney(c.getWallet().getMoney() - 30);
        System.out.println("after reaching through: " + c.getWallet().getMoney());

        // Better: tell the customer what you want; the structure stays private.
        c.pay(20);
        System.out.println("after c.pay(20)       : " + c.balance());
    }
}
class Wallet {
    private int money; Wallet(int m) { money = m; }
    int getMoney() { return money; } void setMoney(int m) { money = m; }
}
class Customer {
    private final Wallet wallet; Customer(Wallet w) { wallet = w; }
    Wallet getWallet() { return wallet; }                     // leaks the internal structure
    void pay(int amount) { if (amount > wallet.getMoney()) throw new IllegalStateException("broke"); wallet.setMoney(wallet.getMoney() - amount); }
    int balance() { return wallet.getMoney(); }
}
