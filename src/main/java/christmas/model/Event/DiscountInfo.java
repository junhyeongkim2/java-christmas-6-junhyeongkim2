package christmas.model.Event;

public class DiscountInfo {

    private String name;
    private long discount;

    public DiscountInfo(String name, long discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return this.name;
    }

    public long getDiscount() {
        return this.discount;
    }

}
