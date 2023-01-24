import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        Customer JaneDoe = new Customer("Jane Doe");
        Customer Yassine = new Customer("Yassine Ghandri");
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(JaneDoe);
        customers.add(Yassine);
        System.out.println(customers);
        ShoppingCart cart = new ShoppingCart();
        try {
            Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
            System.out.println(toothbrush);

            LineItem toothbrushes = new LineItem(toothbrush, 2);
            cart.addLineItems(toothbrushes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(cart);

        if (!cart.getLineItems().isEmpty()) {
            JaneDoe.addPaymentMethod("Jane Credit Card", new CreditCard(1234567890L));
            JaneDoe.addPaymentMethod("Jane Bank Account", new BankAccount(111, 98765432));
            JaneDoe.addPaymentMethod("Jane ETF Account", new EtfAccount("yassine@gmail.com"));
            Optional<Order> order = JaneDoe.checkout(cart, "Jane Credit Card");
            System.out.println(order);
        }
        Map<Integer, Long> discountMap = customers.stream()
                .collect(Collectors.groupingBy(Customer::calculateDiscount, Collectors.counting()));

        System.out.println(discountMap);

        discountMap = new HashMap<>();
        for (Customer c : customers) {
            discountMap.merge(c.calculateDiscount(), 1L, Long::sum);
        }

        System.out.println(discountMap);


    }
}