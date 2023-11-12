package christmas.model;

import christmas.model.Event.EventType;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jdk.jfr.Event;

public class EventChecker {

    private EventResult eventResult;


    public EventResult checkEvent(Menus menus, int day) {
        return null;
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        eventResult = checkEvent(menus, day);
        return eventResult.calculateTotalBenefit();
    }

    public long calculateExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public List<EventType> checkEventResult() {
        return eventResult.getEventResult();
    }


    public EventType checkDdayDiscount(int day) {
        return DiscountEvent.Dday().calculateDiscountAmount(day);
    }

    public EventType checkWeekdayDiscount(Menus menus, int day) {
        return DiscountEvent.Weekday().calculateDiscountAmount(menus, day);
    }

    public EventType checkWeekendDiscount(Menus menus, int day) {
        return DiscountEvent.Weekend().calculateDiscountAmount(menus, day);
    }


    public EventType checkSpecialDiscount(int day) {
        return DiscountEvent.Special().calculateDiscountAmount(day);
    }

    public EventType checkGiveawayMenu(long totalOrderAmount) {
        return DiscountEvent.Giveaway().calculateDiscountAmount(totalOrderAmount);
    }

    public Badge checkEventBadge() {
        return eventResult.generateBadge();
    }


}
