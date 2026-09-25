/** Run: java design-patterns/examples/ChainDemo.java  Pass a request along handlers; each may handle it or pass it on. */
public class ChainDemo {
    public static void main(String[] args) {
        Handler chain = new AuthHandler(new RateLimitHandler(new BusinessHandler(null)));
        System.out.println(chain.handle(new Request("ann", 1, "buy")));
        System.out.println(chain.handle(new Request(null, 1, "buy")));
        System.out.println(chain.handle(new Request("bob", 999, "buy")));
        System.out.println(new AuthHandler(null).handle(new Request("ann", 1, "buy")));   // a chain with no handler for it: request unhandled
    }
}
record Request(String user, int rate, String action) { }
abstract class Handler {
    private final Handler next; Handler(Handler next) { this.next = next; }
    String handle(Request r) { String result = check(r); if (result != null) return result; return next != null ? next.handle(r) : "unhandled"; }
    abstract String check(Request r);     // return a result to stop the chain, or null to pass on
}
class AuthHandler extends Handler { AuthHandler(Handler n) { super(n); } String check(Request r) { return r.user() == null ? "401 not authenticated" : null; } }
class RateLimitHandler extends Handler { RateLimitHandler(Handler n) { super(n); } String check(Request r) { return r.rate() > 100 ? "429 too many requests" : null; } }
class BusinessHandler extends Handler { BusinessHandler(Handler n) { super(n); } String check(Request r) { return "200 did " + r.action() + " for " + r.user(); } }
