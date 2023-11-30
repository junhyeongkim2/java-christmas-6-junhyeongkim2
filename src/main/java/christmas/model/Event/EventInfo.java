package christmas.model.Event;

import christmas.model.Menu;

public enum EventInfo {

    NONE("NONE", 0),
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인", 100),
    WEEKDAY_EVENT("평일 할인", 2023),
    WEEKEND_EVENT("주말 할인", 2023),
    SPECIAL_EVENT("특별 할인", 1000),
    GIVEAWAY_EVENT("증정 이벤트", Menu.샴페인.getPrice());
    private String name;
    private int discount;

    EventInfo(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
