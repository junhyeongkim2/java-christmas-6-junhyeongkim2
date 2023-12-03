package christmas.model.Event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import christmas.model.Order;
import java.util.Map;

public class GiveawayEvent implements EventPolicy {
    private final int day;
    private final Order order;

    public GiveawayEvent(int day, Order order) {
        this.day = day;
        this.order = order;
    }

    @Override
    public EventInfo getEventInfo() {
        return EventInfo.GIVEAWAY_EVENT;
    }

    @Override
    public String getEventName() {
        return String.valueOf(EventInfo.GIVEAWAY_EVENT.getName());
    }

    @Override
    public boolean isSatisfied(int day, Order order) {
        if (order.calculateTotalOrderAmount() >= 120000) {
            return true;
        }
        return false;
    }

    @Override
    public int discount() {
        if (isSatisfied(day, order)) {
            return Menu.샴페인.getPrice();
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
