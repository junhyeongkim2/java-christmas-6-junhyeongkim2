package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;
import jdk.jfr.Event;

public class Weekday extends DiscountEvent {

    @Override
    protected EventType calculateDiscountAmount(Menus menus, int day) {
        if (day % 7 != 1 && day % 7 != 2) {
            EventType.WEEKDAY.addDiscount(menus.totalEventMatchAmount("디저트") * 2023);
            return EventType.WEEKDAY;
        }
        return EventType.WEEKDAY;
    }

    @Override
    protected EventType calculateDiscountAmount(int day) {
        return null;
    }

    @Override
    protected EventType calculateDiscountAmount(long totalOrderAmount) {
        return null;
    }


}
