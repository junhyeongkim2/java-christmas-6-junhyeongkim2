package christmas.model.Event;

import christmas.model.DiscountInfo;
import christmas.model.Menu.IMenu;
import java.util.List;

public class ChristmasEvent implements Event{
    private final List<IDiscount> discountInfoList;

    public ChristmasEvent(IMenu menu, List<IDiscount> discountInfoList) {
        this.discountInfoList = discountInfoList;
    }
    @Override
    public int getPrice() {
        int sum = 0;
        for (IDiscount discount : discountInfoList) {
            sum = sum + discount.discount();
        }
       return sum;
    }
}
