package christmas.model.Event;

public enum EventType {

    DDAY("크리스마스 디데이 할인", 0),
    WEEKDAY("평일 할인", 0),
    WEEKEND("주말 할인", 0),
    SPECIAL("특별 할인", 0),
    GIVEAWAY("증정 이벤트", 0);

    private final String name;
    private int discount;

    EventType(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public void addDiscount(long discount) {
        this.discount += discount;
    }


    public int getDiscount() {
        return this.discount;
    }


}
