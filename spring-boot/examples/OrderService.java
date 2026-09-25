// SNIPPET (not compiled here): constructor injection, per the Spring Framework reference.
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentGateway payments;      // mandatory dependency => final field

    // Single constructor: Spring injects PaymentGateway from the container.
    public OrderService(PaymentGateway payments) {
        this.payments = payments;
    }
}
