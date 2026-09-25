/** Run: java java/examples/StringDemo.java */
public class StringDemo {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";                  // same literal: same interned object
        String c = new String("abc");      // explicitly a new object
        System.out.println("a == b          : " + (a == b));
        System.out.println("a == c          : " + (a == c));
        System.out.println("a.equals(c)     : " + a.equals(c));
        System.out.println("a == c.intern() : " + (a == c.intern()));

        String s = "x";
        String t = s.concat("y");          // returns a NEW string; s is unchanged
        System.out.println("s after concat  : " + s + ", t = " + t);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i).append(',');
        System.out.println("StringBuilder   : " + sb);
    }
}
