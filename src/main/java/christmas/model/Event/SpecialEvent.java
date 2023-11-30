package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.List;
import java.util.Map;

public class SpecialEvent implements EventPolicy {

    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.SPECIAL_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        if (specialDay.contains(day)) {
            return true;
        }
        return false;
    }

    @Override
    public int discount(int day, Map<Menu, Integer> menus) {
        if (isSatisfied(day, menus)) {
            return 1000;
        }
        return 0;
    }

}
