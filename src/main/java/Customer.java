import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Customer implements Comparable<Customer> {
    private final String name;
    private Map<String, PaymentMethod> paymentMethods = new HashMap<>();
    public void addPaymentMethod(String nickname, PaymentMethod paymentMethod) {
        paymentMethods.put(nickname, paymentMethod);
    }
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int calculateDiscount() {
        return 0;
    }

    public Optional<Order> checkout(ShoppingCart cart, String paymentMethodeNickname) {
        Optional<PaymentMethod> paymentMethod =
                Optional.ofNullable(paymentMethods.get(paymentMethodeNickname));
        Optional<Payment> payment = paymentMethod.flatMap(pm -> pm.mkPayment(cart.getTotalPrice()));
        return payment.map(value -> new Order(this, cart, Optional.of(value)));
    }

    @Override
    public int compareTo(Customer customer) {
        return name.compareTo(customer.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}

