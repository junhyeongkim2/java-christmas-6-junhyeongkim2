package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;

public class Weekend extends DiscountEvent {

    @Override
    protected EventType calculateDiscountAmount(Menus menus, int day) {
        if (day % 7 == 1 || day % 7 == 2) {
            EventType.WEEKEND.addDiscount(menus.totalEventMatchAmount("메인") * 2023);
            return EventType.WEEKEND;
        }
        return EventType.WEEKEND;
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
