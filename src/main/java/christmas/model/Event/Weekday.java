package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;

public class Weekday extends DiscountEvent {
    @Override
    protected int getDiscountAmount() {
        return 0;
    }

    @Override
    protected int isSatisfiedBy(Menus menus, int day) {
        return 0;
    }

    @Override
    protected int isSatisfiedBy(int day) {
        return 0;
    }
}
