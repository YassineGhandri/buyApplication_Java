import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    public final static int SHIPPING_RATE = 5;

/*
    // Java 9 and later
    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new PhysicalProduct("Electric Toothbrush", 5000, 400, STANDARD),
            "Baby Alarm", new PhysicalProduct("Baby Alarm", 5000, 500, STANDARD),
            "Sofa", new PhysicalProduct("Super Sofa", 50_000, 500_000, BULKY),
            "War and Peace (e-book)", new DigitalProduct("War and Peace (e-book)", 1000)
    );
*/

    // Java 8 and earlier
    public static Map<String, Product> productMap = new HashMap<>();
    static {
        productMap.put("Electric Toothbrush", new PhysicalProduct("Electric Toothbrush", 3000, 400, PhysicalProduct.ShippingCategory.STANDARD));
        productMap.put("Baby Alarm", new PhysicalProduct("Baby Alarm", 5000, 500, PhysicalProduct.ShippingCategory.STANDARD));
        productMap.put("Sofa", new PhysicalProduct("Super Sofa", 50_000, 500_000, PhysicalProduct.ShippingCategory.BULKY));
        productMap.put("War and Peace (e-book)", new DigitalProduct("War and Peace (e-book)", 1000));
    }

    public static Product getProduct(String productName) {
        Product product = productMap.get(productName);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }
}
