package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.util.Map;

public class GiveawayEvent implements EventPolicy {
    private final int day;
    private final Map<Menu, Integer> menus;

    public GiveawayEvent(int day, Map<Menu, Integer> menus) {
        this.day = day;
        this.menus = menus;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.GIVEAWAY_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        if (menus.keySet().stream().mapToInt(menu -> Menu.valueOf(String.valueOf(menu)).getPrice()).sum() >= 120000) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, menus)) {
            return Menu.샴페인.getPrice();
        }
        return 0;
    }

}
