package christmas.model.Event;

import christmas.model.Menu.Menu;

public enum EventType {

    DDAY("크리스마스 디데이 할인", 100),
    WEEKDAY("평일 할인", 2023),
    WEEKEND("주말 할인", 2023),
    SPECIAL("특별 할인", 1000),
    GIVEAWAY("증정 이벤트", Menu.샴페인.getPrice());

    private final String name;
    private int discount;

    EventType(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return this.name;
    }

    public int getDiscount() {
        return this.discount;
    }


}
