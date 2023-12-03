package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import christmas.model.Order;
import java.util.List;
import java.util.Map;

public class ChristmasDdayEvent implements EventPolicy {

    private final int day;
    private final Order order;

    public ChristmasDdayEvent(int day, Order order) {
        this.day = day;
        this.order = order;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.CHRISTMAS_D_DAY_EVENT;
    }

    @Override
    public String getEventName() {
        return String.valueOf(EventInfo.CHRISTMAS_D_DAY_EVENT.getName());
    }

    @Override
    public boolean isSatisfied(int day, Order order) {
        if (1 <= day && day <= 25) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, order)) {
            return 1000 + ((day - 1) * EventInfo.CHRISTMAS_D_DAY_EVENT.getDiscount());
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
