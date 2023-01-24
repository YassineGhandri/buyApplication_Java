public class NonprofitCustomer  extends  Customer{
    public NonprofitCustomer(String name, long ccNumber) {
        super(name);
    }
    public int calculateDiscount(){
        return 15;
    }
}
