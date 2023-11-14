package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Weekday extends DiscountEvent {


    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day % DiscountEvent.SEVENDAYS != DiscountEvent.WEEKEND_ONE
                && day % DiscountEvent.SEVENDAYS != DiscountEvent.WEEKEND_TWO) {
            return new DiscountInfo(EventType.WEEKDAY.getName(),
                    -menus.totalEventMatchAmount("디저트") * EventType.WEEKDAY.getDiscount());
        }
        return new DiscountInfo(EventType.WEEKDAY.getName(), DiscountEvent.ZERO_DISCOUNT);
    }

}
