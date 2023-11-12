package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;
import jdk.jfr.Event;

public class Giveaway extends DiscountEvent {


    @Override
    protected EventType calculateDiscountAmount(Menus menus, int day) {
        return null;
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
