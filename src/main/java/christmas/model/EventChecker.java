package christmas.model;

import christmas.model.Event.DiscountInfo;
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
        return EventResult.createFrom(
                List.of(checkDdayDiscount(day), checkWeekdayDiscount(menus, day), checkWeekendDiscount(menus, day),
                        checkSpecialDiscount(day), checkGiveawayMenu(menus, day)));
    }

    public EventResult createEmptyEventResult() {
        return EventResult.createFrom(List.of());
    }


    public long checkTotalBenefitAmount(Menus menus, int day) {
        eventResult = createEventResult(menus, day);
        return eventResult.calculateTotalBenefit();
    }

    public long checkExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
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
