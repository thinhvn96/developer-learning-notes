import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

// Lessons 0011 and 0015. Usage: OrderConsumer <classic|consumer>
// Reads "orders" in group "billing", processes, then commits (at-least-once).
public class OrderConsumer {
    public static void main(String[] args) {
        String protocol = args.length > 0 ? args[0] : "classic";
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "billing-" + protocol);
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");   // we commit after processing
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // new group: start from the beginning
        p.put(ConsumerConfig.GROUP_PROTOCOL_CONFIG, protocol);      // "consumer" = KIP-848 protocol

        try (Consumer<String, String> consumer = new KafkaConsumer<>(p)) {  // NOT thread-safe: one per thread
            consumer.subscribe(List.of("orders"));
            int seen = 0, emptyPolls = 0;
            while (seen < 6 && emptyPolls < 20) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
                if (records.isEmpty()) { emptyPolls++; continue; }
                for (ConsumerRecord<String, String> r : records) {
                    System.out.printf("[%s] p%d@%d %s=%s%n", protocol, r.partition(), r.offset(), r.key(), r.value());
                    seen++;
                }
                consumer.commitSync();                              // 1. process  2. commit  => at-least-once
            }
        }
    }
}
