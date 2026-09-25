/** Run: java java/examples/NpeDemo.java  (JDK 21 prints which expression was null) */
public class NpeDemo {
    static class Address { String city; }
    static class User { Address address; }

    public static void main(String[] args) {
        User u = new User();
        try {
            System.out.println(u.address.city.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        String[] names = new String[1];
        try {
            names[0].trim();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
