package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;

public class Weekend extends DiscountEvent {

    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day % 7 == 1 || day % 7 == 2) {
            return new DiscountInfo(EventType.WEEKEND.getName(), -(menus.totalEventMatchAmount("메인") * 2023));
        }
        return new DiscountInfo(EventType.WEEKDAY.getName(), 0);
    }

    @Override
    protected DiscountInfo calculateDiscountAmount(int day) {
        return null;
    }

}
