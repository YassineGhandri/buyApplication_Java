public class BusinessCustomer extends Customer{

    public enum BusinessSize {SMALL,MEDIUM,LARGE};
    public BusinessSize size;

    public BusinessCustomer(String name, long ccNumber, BusinessSize size) {
        super(name);
        this.size = size;
    }
            public String getname(){
                  return   super.getName();
            }
    @Override
    public int calculateDiscount() {
        switch (size){
            case SMALL:
                return 5;
            case MEDIUM:
                return 10;
            case LARGE:
                return 20;

            default:
                throw new AssertionError ("unkwon size type"+this);
        }
    }

    @Override
    public String toString() {
        return "BusinessCustomer{" +
                super.toString() +
                "size=" + size +
                '}';
    }
}
