import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<LineItem> lineItems=new ArrayList<>();
    public void addLineItems(LineItem lineItem){
        lineItems.add(lineItem);
    }

    public int getTotalPrice(){
        return lineItems.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "lineItems=" +  lineItems.stream().map(Object::toString)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
