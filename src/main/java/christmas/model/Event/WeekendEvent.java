package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.Map;

public class WeekendEvent implements EventPolicy {
    @Override
    public EventInfo getEventInfo() {
        return EventInfo.WEEKEND_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        return false;
    }

    @Override
    public int discount(int day, Map<Menu, Integer> menus) {
        return 0;
    }

}
