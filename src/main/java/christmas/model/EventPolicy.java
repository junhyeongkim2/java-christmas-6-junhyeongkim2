package christmas.model;

import christmas.model.Event.EventInfo;
import java.util.Map;

public interface EventPolicy {

    public EventInfo getEventInfo();

    public boolean isSatisfied(int day, Map<Menu, Integer> menus);

    public int discount();

}
