package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.List;
import java.util.Map;

public class ChristmasDdayEvent implements EventPolicy {

    private final int day;
    private final Map<Menu, Integer> menus;

    public ChristmasDdayEvent(int day, Map<Menu, Integer> menus) {
        this.day = day;
        this.menus = menus;
    }

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
    public int discount() {
        if (isSatisfied(day, menus)) {
            return 1000 + ((day - 1) * EventInfo.CHRISTMAS_D_DAY_EVENT.getDiscount());
        }
        return 0;
    }

}
