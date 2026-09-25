/** Run: java system-design/examples/TokenBucketDemo.java  A token-bucket rate limiter: steady rate with a small burst. */
public class TokenBucketDemo {
    static class TokenBucket {
        private final double capacity, refillPerSecond; private double tokens; private long last;
        TokenBucket(double capacity, double refillPerSecond) { this.capacity = capacity; this.refillPerSecond = refillPerSecond; this.tokens = capacity; this.last = System.nanoTime(); }
        synchronized boolean tryAcquire() {
            long now = System.nanoTime();
            tokens = Math.min(capacity, tokens + (now - last) / 1e9 * refillPerSecond);
            last = now;
            if (tokens >= 1) { tokens -= 1; return true; }
            return false;                                     // caller should back off (HTTP 429 in an API)
        }
    }

    public static void main(String[] args) throws Exception {
        TokenBucket bucket = new TokenBucket(5, 10);          // burst of 5, then 10 per second
        int allowed = 0, rejected = 0;
        System.out.println("--- 20 requests fired instantly");
        for (int i = 0; i < 20; i++) { if (bucket.tryAcquire()) allowed++; else rejected++; }
        System.out.println("allowed=" + allowed + " rejected=" + rejected);
        System.out.println("--- 1 second of requests every 10 ms (100 attempts)");
        allowed = 0; rejected = 0;
        long end = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < end) { if (bucket.tryAcquire()) allowed++; else rejected++; Thread.sleep(10); }
        System.out.println("allowed=" + allowed + " (about the refill rate of 10/s) rejected=" + rejected);
    }
}
