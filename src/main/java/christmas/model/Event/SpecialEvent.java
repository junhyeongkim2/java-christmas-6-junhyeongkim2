package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import christmas.model.Order;
import java.util.List;
import java.util.Map;

public class SpecialEvent implements EventPolicy {
    private final int day;
    private final Order order;

    public SpecialEvent(int day, Order order) {
        this.day = day;
        this.order = order;
    }

    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.SPECIAL_EVENT;
    }

    @Override
    public String getEventName() {
        return String.valueOf(EventInfo.SPECIAL_EVENT.getName());
    }

    @Override
    public boolean isSatisfied(int day, Order order) {
        if (specialDay.contains(day)) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, order)) {
            return EventInfo.SPECIAL_EVENT.getDiscount();
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
}
