package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;

public class Dday extends DiscountEvent {


    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day > 25) {
            return new DiscountInfo(EventType.DDAY.getName(), 0);
        }
        return new DiscountInfo(EventType.DDAY.getName(), -((day + 9) * EventType.DDAY.getDiscount()));
    }


}
