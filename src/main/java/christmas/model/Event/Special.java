package christmas.model.Event;

import christmas.model.DiscountEvent;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menus;
import java.util.List;

public class Special extends DiscountEvent {
    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    @Override
    protected DiscountInfo calculateDiscountAmount(Menus menus, int day) {
        if (specialDay.contains(day)) {
            return new DiscountInfo(EventType.SPECIAL.getName(), -EventType.SPECIAL.getDiscount());
        }
        return new DiscountInfo(EventType.SPECIAL.getName(), DiscountEvent.ZERO_DISCOUNT);
    }

}
