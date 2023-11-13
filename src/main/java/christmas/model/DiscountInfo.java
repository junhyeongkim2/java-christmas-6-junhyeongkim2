package christmas.model;

public class DiscountInfo {

    private final String name;
    private final long discount;

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
