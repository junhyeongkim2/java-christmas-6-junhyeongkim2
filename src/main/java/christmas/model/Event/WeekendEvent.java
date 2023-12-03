package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekendEvent implements EventPolicy {
    private final int day;
    private final Map<Menu, Integer> menus;

    public WeekendEvent(int day, Map<Menu, Integer> menus) {
        this.day = day;
        this.menus = menus;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.WEEKEND_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        LocalDate date = LocalDate.of(2023, 12, day);
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, menus)) {
            return menus.keySet().stream().filter(key -> Menu.valueOf(String.valueOf(key)).isMain())
                    .mapToInt(key -> menus.get(key)).sum() * EventInfo.WEEKEND_EVENT.getDiscount();
        }
        return 0;
    }

}
