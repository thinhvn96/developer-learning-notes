/** Run: java oop/examples/StaticMembers.java  Class variables are shared; static methods have no 'this'. */
public class StaticMembers {
    public static void main(String[] args) {
        System.out.println("before: " + Counter.total());
        Counter a = new Counter(), b = new Counter(), c = new Counter();
        System.out.println("after 3 objects, shared count = " + Counter.total());
        System.out.println("instance ids: " + a.id + ", " + b.id + ", " + c.id);
        System.out.println("constant: " + Counter.MAX);
    }
}
class Counter {
    static final int MAX = 100;              // constant: static + final
    private static int created = 0;          // ONE copy shared by all instances
    final int id;                            // one copy PER instance
    Counter() { id = ++created; }
    static int total() { return created; }   // a static method cannot read 'id' or use 'this'
}
