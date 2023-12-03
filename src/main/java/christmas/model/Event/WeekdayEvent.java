package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WeekdayEvent implements EventPolicy {
    private final int day;
    private final Map<Menu, Integer> menus;
    public WeekdayEvent(int day, Map<Menu, Integer> menus) {
        this.day = day;
        this.menus = menus;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.WEEKDAY_EVENT;
    }

    @Override
    public boolean isSatisfied(int day, Map<Menu, Integer> menus) {
        LocalDate date = LocalDate.of(2023, 12, day);
        if (!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, menus)) {
            return menus.keySet().stream().filter(key -> Menu.valueOf(String.valueOf(key)).isDessert()).mapToInt(key->menus.get(key)).sum() * EventInfo.WEEKDAY_EVENT.getDiscount();
        }
        return 0;
    }

}
