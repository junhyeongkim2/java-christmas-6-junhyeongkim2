package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Giveaway extends DiscountEvent {


    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (menus.totalOrderAmount() >= 120000) {
            return new DiscountInfo(EventType.GIVEAWAY.getName(), -EventType.GIVEAWAY.getDiscount());
        }
        return new DiscountInfo(EventType.GIVEAWAY.getName(), 0);
    }


}
