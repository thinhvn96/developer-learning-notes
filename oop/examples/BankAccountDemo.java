/** Run: java oop/examples/BankAccountDemo.java  State + behavior, and encapsulation guarding an invariant. */
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("ann", 100);
        a.deposit(50);
        a.withdraw(30);
        System.out.println(a.describe());
        try { a.withdraw(1000); } catch (IllegalStateException e) { System.out.println("rejected: " + e.getMessage()); }
        try { a.deposit(-5); } catch (IllegalArgumentException e) { System.out.println("rejected: " + e.getMessage()); }
        // a.balance = -1_000_000;   // does not compile: balance is private
    }
}

class BankAccount {
    private final String owner;      // state, hidden
    private int balance;             // invariant: balance >= 0

    BankAccount(String owner, int opening) {
        if (opening < 0) throw new IllegalArgumentException("opening balance must be >= 0");
        this.owner = owner; this.balance = opening;
    }
    void deposit(int amount) {       // behavior: the only way to change state
        if (amount <= 0) throw new IllegalArgumentException("deposit must be positive");
        balance += amount;
    }
    void withdraw(int amount) {
        if (amount > balance) throw new IllegalStateException("insufficient funds");
        balance -= amount;
    }
    String describe() { return owner + " has " + balance; }
}
