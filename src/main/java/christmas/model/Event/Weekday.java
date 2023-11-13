package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Weekday extends DiscountEvent {

    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day % 7 != 1 && day % 7 != 2) {
            return new DiscountInfo(EventType.WEEKDAY.getName(),
                    menus.totalEventMatchAmount("디저트") * -EventType.WEEKEND.getDiscount());
        }
        return new DiscountInfo(EventType.WEEKDAY.getName(), 0);
    }

}
