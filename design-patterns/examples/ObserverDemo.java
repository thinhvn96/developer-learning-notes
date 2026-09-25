import java.util.*;
import java.util.concurrent.*;

/** Run: java design-patterns/examples/ObserverDemo.java  A subject notifies subscribers; the JDK's modern version is java.util.concurrent.Flow. */
public class ObserverDemo {
    public static void main(String[] args) throws Exception {
        StockTicker t = new StockTicker();
        t.subscribe(p -> System.out.println("A sees " + p));
        Consumer2 b = p -> System.out.println("B sees " + p);
        t.subscribe(b);
        t.setPrice(10);
        t.unsubscribe(b);                                             // subscriptions are dynamic
        t.setPrice(11);

        System.out.println("--- Flow API (Publisher/Subscriber with back-pressure)");
        try (SubmissionPublisher<Integer> pub = new SubmissionPublisher<>()) {
            CountDownLatch done = new CountDownLatch(1);
            pub.subscribe(new Flow.Subscriber<>() {
                Flow.Subscription s;
                public void onSubscribe(Flow.Subscription s) { this.s = s; s.request(1); }             // the subscriber controls the pace
                public void onNext(Integer i) { System.out.println("Flow got " + i); s.request(1); }
                public void onError(Throwable t) { }
                public void onComplete() { done.countDown(); }
            });
            for (int i = 1; i <= 3; i++) pub.submit(i);
            pub.close();
            done.await();
        }
    }
}
interface Consumer2 { void update(int price); }
class StockTicker {
    private final List<Consumer2> subscribers = new ArrayList<>();
    void subscribe(Consumer2 c) { subscribers.add(c); }
    void unsubscribe(Consumer2 c) { subscribers.remove(c); }
    void setPrice(int p) { for (Consumer2 c : List.copyOf(subscribers)) c.update(p); }
}
