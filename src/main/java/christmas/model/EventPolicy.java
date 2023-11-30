package christmas.model;

import christmas.model.Event.EventInfo;

public interface EventPolicy {
    public EventInfo getEventInfo();

    public boolean isSatisfied(int day, String menus);

    public int discount(int day, String menus);

}
