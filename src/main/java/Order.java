import java.util.Optional;

public class Order {
    private Customer customer;
    private ShoppingCart cart;
    private Optional<Payment> payment;

    public Order(Customer customer, ShoppingCart cart, Optional<Payment> payment) {
        this.customer = customer;
        this.cart = cart;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", cart=" + cart +
                ", payment=" + payment +
                '}';
    }
}
