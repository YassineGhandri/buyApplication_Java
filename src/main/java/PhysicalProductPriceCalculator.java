import java.util.HashMap;
import java.util.Map;

public class PhysicalProductPriceCalculator implements PriceCalculator {
    private static final int BULK_COST_FACTOR = 1;
    private static final int STANDARD_COST_FACTOR = 10;
    private static final int PREMIUM_COST_FACTOR = 50;
    private PhysicalProduct product;

/*
   // Java 9 and later
   private final Map<ShippingCategory,Integer> shippingCostFactors = Map.of (
         BULKY, BULK_COST_FACTOR,
         STANDARD, STANDARD_COST_FACTOR,
         PREMIUM, PREMIUM_COST_FACTOR);
*/

    // Java 8 and earlier
    private final Map<PhysicalProduct.ShippingCategory,Integer> shippingCostFactors;

    public PhysicalProductPriceCalculator(PhysicalProduct product) {
        this.product = product;
        // Java 8 and earlier
        shippingCostFactors = new HashMap<>();
        shippingCostFactors.put(PhysicalProduct.ShippingCategory.BULKY, BULK_COST_FACTOR);
        shippingCostFactors.put(PhysicalProduct.ShippingCategory.STANDARD, STANDARD_COST_FACTOR);
        shippingCostFactors.put(PhysicalProduct.ShippingCategory.PREMIUM, PREMIUM_COST_FACTOR);
    }

    @Override
    public int calculatePrice(int quantity) {
        int weight = product.getWeight();
        PhysicalProduct.ShippingCategory shippingCategory = product.getShippingCategory();
        int shippingCosts = shippingCostFactors.get(shippingCategory) * weight;
        return quantity * ( shippingCosts +
                Math.round((1 - product.getProductDiscount())
                        * product.getBasePrice()));
    }
}
