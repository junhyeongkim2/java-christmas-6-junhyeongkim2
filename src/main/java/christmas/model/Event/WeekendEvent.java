package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import christmas.model.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekendEvent implements EventPolicy {
    private final int day;
    private final Order order;

    public WeekendEvent(int day, Order order) {
        this.day = day;
        this.order = order;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.WEEKEND_EVENT;
    }

    @Override
    public String getEventName() {
        return String.valueOf(EventInfo.WEEKEND_EVENT.getName());
    }

    @Override
    public boolean isSatisfied(int day, Order order) {
        LocalDate date = LocalDate.of(2023, 12, day);
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && order.calculateTotalOrderAmount() >= 10000) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, order)) {
            return order.calculateTotalMainOrderAmount() * EventInfo.WEEKEND_EVENT.getDiscount();
        }
        return 0;
    }

    @Override
    public boolean isWinningEvents() {
        if (discount() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGiveaway() {
        return false;
    }
}
