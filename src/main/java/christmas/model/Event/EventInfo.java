package christmas.model.Event;

public enum EventInfo {


    NONE("NONE"),
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인"),
    WEEKDAY_EVENT("평일 할인"),
    WEEKEND_EVENT("주말 할인"),
    SPECIAL_EVENT("특별 할인"),
    GIVEAWAY_EVENT("증정 이벤트");
    private String name;

    EventInfo(String name) {
        this.name = name;
    }
}
