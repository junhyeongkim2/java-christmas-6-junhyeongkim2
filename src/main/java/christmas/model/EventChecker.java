package christmas.model;

import christmas.model.Menu.Menus;
import java.util.List;

public class EventChecker {

    private EventResult eventResult;

    public EventResult createEventResult(Menus menus, int day) {
        if (menus.totalOrderAmount() >= 10000) {
            return createContainedEventResult(menus, day);
        }
        return createEmptyEventResult();
    }

    public EventResult createContainedEventResult(Menus menus, int day) {
        eventResult = EventResult.createFrom(
                List.of(checkDdayDiscount(menus, day), checkWeekdayDiscount(menus, day), checkWeekendDiscount(menus, day),
                        checkSpecialDiscount(menus, day), checkGiveawayMenu(menus, day)));
        return eventResult;
    }

    public EventResult createEmptyEventResult() {
        eventResult = EventResult.createFrom(List.of());
        return eventResult;
    }


    public long checkTotalBenefitAmount() {
        return eventResult.calculateTotalBenefit();
    }

    public long checkExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public DiscountInfo checkDdayDiscount(Menus menus, int day) {
        return DiscountEvent.Dday().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkWeekdayDiscount(Menus menus, int day) {
        return DiscountEvent.Weekday().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkWeekendDiscount(Menus menus, int day) {
        return DiscountEvent.Weekend().calculateDiscountAmount(menus, day);
    }


    public DiscountInfo checkSpecialDiscount(Menus menus, int day) {
        return DiscountEvent.Special().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkGiveawayMenu(Menus menus, int day) {
        return DiscountEvent.Giveaway().calculateDiscountAmount(menus, day);
    }

    public Badge checkEventBadge() {
        return eventResult.generateBadge();
    }


}
