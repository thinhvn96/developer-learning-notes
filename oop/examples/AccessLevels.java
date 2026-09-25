/** Run: java oop/examples/AccessLevels.java  Encapsulation with validation; access modifiers are enforced by the compiler. */
public class AccessLevels {
    public static void main(String[] args) {
        Temperature t = new Temperature(20);
        t.setCelsius(25);
        System.out.println("celsius=" + t.getCelsius() + " fahrenheit=" + t.fahrenheit());
        try { t.setCelsius(-300); } catch (IllegalArgumentException e) { System.out.println("rejected: " + e.getMessage()); }
        // t.celsius = -300;   // compile error in another class: celsius is private
    }
}
class Temperature {
    private double celsius;                        // private: invariant celsius >= -273.15 is enforced in ONE place
    Temperature(double c) { setCelsius(c); }
    public double getCelsius() { return celsius; }
    public void setCelsius(double c) {
        if (c < -273.15) throw new IllegalArgumentException("below absolute zero: " + c);
        celsius = c;
    }
    public double fahrenheit() { return celsius * 9 / 5 + 32; }   // derived value: no stored duplicate to go stale
}
