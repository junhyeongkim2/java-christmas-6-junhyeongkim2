package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.List;
import java.util.Map;

public class SpecialEvent implements EventPolicy {
    private final int day;
    private final Map<Menu, Integer> menus;

    public SpecialEvent(int day, Map<Menu, Integer> menus) {
        this.day = day;
        this.menus = menus;
    }

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
    public int discount() {
        if (isSatisfied(day, menus)) {
            return EventInfo.SPECIAL_EVENT.getDiscount();
        }
        return 0;
    }

}
