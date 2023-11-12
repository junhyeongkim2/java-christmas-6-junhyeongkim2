package christmas.model;

import christmas.model.Event.DiscountInfo;
import christmas.model.Menu.Menus;
import java.util.List;

public class EventChecker {

    private EventResult eventResult;


    public EventResult checkEvent(Menus menus, int day) {
        return EventResult.createFrom(
                List.of(checkDdayDiscount(day), checkWeekdayDiscount(menus, day), checkWeekendDiscount(menus, day),
                        checkSpecialDiscount(day), checkGiveawayMenu(menus, day)));
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        eventResult = checkEvent(menus, day);
        return eventResult.calculateTotalBenefit();
    }

    public long calculateExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public List<DiscountInfo> checkEventResult() {
        return eventResult.getEventResult();
    }


    public DiscountInfo checkDdayDiscount(int day) {
        return DiscountEvent.Dday().calculateDiscountAmount(day);
    }

    public DiscountInfo checkWeekdayDiscount(Menus menus, int day) {
        return DiscountEvent.Weekday().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkWeekendDiscount(Menus menus, int day) {
        return DiscountEvent.Weekend().calculateDiscountAmount(menus, day);
    }


    public DiscountInfo checkSpecialDiscount(int day) {
        return DiscountEvent.Special().calculateDiscountAmount(day);
    }

    public DiscountInfo checkGiveawayMenu(Menus menus, int day) {
        return DiscountEvent.Giveaway().calculateDiscountAmount(menus, day);
    }

    public Badge checkEventBadge() {
        return eventResult.generateBadge();
    }


}
