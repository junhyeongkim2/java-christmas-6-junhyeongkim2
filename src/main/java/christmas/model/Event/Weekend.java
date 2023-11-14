package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;

public class Weekend extends DiscountEvent {

    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (day % DiscountEvent.SEVENDAYS == DiscountEvent.WEEKEND_ONE
                || day % DiscountEvent.SEVENDAYS == DiscountEvent.WEEKEND_TWO) {
            return new DiscountInfo(EventType.WEEKEND.getName(),
                    -(menus.totalEventMatchAmount("메인") * EventType.WEEKEND.getDiscount()));
        }
        return new DiscountInfo(EventType.WEEKEND.getName(), DiscountEvent.ZERO_DISCOUNT);
    }


}
