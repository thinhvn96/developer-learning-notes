import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

// Lesson 0011. Sends 6 keyed order events and prints where each one landed.
public class OrderProducer {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        p.put(ProducerConfig.ACKS_CONFIG, "all");               // default in 4.x, written out for clarity

        try (Producer<String, String> producer = new KafkaProducer<>(p)) {   // thread-safe: share one per app
            String[][] events = {{"u1", "created"}, {"u2", "created"}, {"u1", "paid"},
                                 {"u3", "created"}, {"u1", "shipped"}, {"u2", "paid"}};
            for (String[] e : events) {
                var record = new ProducerRecord<>("orders", e[0], e[1]);
                producer.send(record, (meta, ex) -> {          // async: callback runs on the producer I/O thread
                    if (ex != null) System.err.println("FAILED " + e[0] + ": " + ex);
                    else System.out.printf("sent key=%s value=%-8s -> partition %d offset %d%n",
                                           e[0], e[1], meta.partition(), meta.offset());
                });
            }
            producer.flush();                                   // wait for in-flight sends before closing
        }
    }
}
