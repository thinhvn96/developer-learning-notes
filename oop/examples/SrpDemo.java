/** Run: java oop/examples/SrpDemo.java  One reason to change per class. */
public class SrpDemo {
    public static void main(String[] args) {
        Invoice inv = new Invoice(200);
        System.out.println(new InvoicePrinter().print(inv));
        new InvoiceStore().save(inv);
        System.out.println("tax: " + new TaxCalculator().tax(inv));
    }
}
/** Before (one class, three reasons to change) would be: calculate tax + format text + persist. After: three classes. */
class Invoice { final int amount; Invoice(int a) { amount = a; } }
class TaxCalculator { int tax(Invoice i) { return i.amount / 10; } }                    // changes when tax rules change
class InvoicePrinter { String print(Invoice i) { return "INVOICE amount=" + i.amount; } } // changes when the layout changes
class InvoiceStore { void save(Invoice i) { System.out.println("saved invoice " + i.amount); } } // changes when storage changes
