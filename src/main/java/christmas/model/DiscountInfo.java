package christmas.model;

public class DiscountInfo {
    private static final String EVENT_NAME_GIVEAWAY = "증정 이벤트";
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

    public Boolean isZeroDiscount() {
        if (discount == 0) {
            return true;
        }
        return false;
    }

    public Boolean isGiveaway() {
        if (name == EVENT_NAME_GIVEAWAY) {
            return true;
        }
        return false;
    }


}
