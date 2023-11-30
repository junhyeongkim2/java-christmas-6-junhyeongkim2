package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.List;
import java.util.Map;

public class ChristmasDdayEvent implements EventPolicy {

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.CHRISTMAS_D_DAY_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        if (1 <= day && day <= 25) {
            return true;
        }
        return false;
    }

    @Override
    public int discount(int day, Map<Menu, Integer> menus) {
        if (isSatisfied(day, menus)) {
            return 1000 + ((day - 1) * 100);
        }
        return 0;
    }

}
