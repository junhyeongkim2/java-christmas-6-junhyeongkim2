package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;
import jdk.jfr.Event;

public class Dday extends DiscountEvent {

    @Override
    protected EventType calculateDiscountAmount(Menus menus, int day) {
        return null;
    }

    @Override
    protected EventType calculateDiscountAmount(int day) {
        if (day > 25) {
            return EventType.DDAY;
        }
        EventType.DDAY.addDiscount((day * 100) + 900);
        return EventType.DDAY;
    }

    @Override
    protected EventType calculateDiscountAmount(long totalOrderAmount) {
        return null;
    }


}
