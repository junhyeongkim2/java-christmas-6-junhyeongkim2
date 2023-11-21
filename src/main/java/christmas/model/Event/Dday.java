package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Dday extends DiscountEvent {

    private static final int DDAY_EVENT_PLUS = 9;

    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day > 25) {
            return new DiscountInfo(EventType.DDAY.getName(), DiscountEvent.ZERO_DISCOUNT);
        }
        return new DiscountInfo(EventType.DDAY.getName(), -((day + DDAY_EVENT_PLUS) * EventType.DDAY.getDiscount()));
    }


}
