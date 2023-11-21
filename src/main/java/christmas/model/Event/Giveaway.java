package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Giveaway extends DiscountEvent {

    private static final int GIVEAWAY_EVENT_AMOUNT = 120000;


    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (menus.totalOrderAmount() >= GIVEAWAY_EVENT_AMOUNT) {
            return new DiscountInfo(EventType.GIVEAWAY.getName(), -EventType.GIVEAWAY.getDiscount());
        }
        return new DiscountInfo(EventType.GIVEAWAY.getName(), DiscountEvent.ZERO_DISCOUNT);
    }


}
