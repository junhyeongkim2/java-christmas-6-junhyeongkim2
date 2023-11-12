package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.Menu.Menus;
import java.util.List;

public class Special extends DiscountEvent {
    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    @Override
    protected EventType calculateDiscountAmount(Menus menus, int day) {
        return null;
    }

    @Override
    protected EventType calculateDiscountAmount(int day) {
        if (specialDay.contains(day)) {
            EventType.SPECIAL.addDiscount(1000);
            return EventType.SPECIAL;
        }
        return EventType.SPECIAL;
    }

    @Override
    protected EventType calculateDiscountAmount(long totalOrderAmount) {
        return null;
    }

}
