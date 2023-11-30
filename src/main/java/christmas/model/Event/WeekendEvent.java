package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekendEvent implements EventPolicy {
    @Override
    public EventInfo getEventInfo() {
        return EventInfo.WEEKEND_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        LocalDate date = LocalDate.of(2023, 12, day);
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return true;
        }
        return false;
    }

    @Override
    public int discount(int day, Map<Menu, Integer> menus) {
        if (isSatisfied(day, menus)) {
            return menus.keySet().stream().filter(key -> Menu.valueOf(String.valueOf(key)).isMain())
                    .mapToInt(key -> menus.get(key)).sum() * EventInfo.WEEKEND_EVENT.getDiscount();
        }
        return 0;
    }

}
