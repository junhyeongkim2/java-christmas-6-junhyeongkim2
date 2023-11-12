package christmas.model;

import christmas.model.Event.DiscountInfo;
import christmas.model.Event.EventType;
import christmas.model.Menu.Menus;

public class Calculator {

    private EventChecker eventChecker;
    private long totalOrderAmount;


    public Calculator() {
        this.eventChecker = new EventChecker();
    }


    public long calculateTotalOrderAmount(Menus menus) {
        totalOrderAmount = menus.totalOrderAmount();
        return totalOrderAmount;
    }

    public DiscountInfo calculateGiveawayMenu(Menus menus, int day) {
        return eventChecker.checkGiveawayMenu(menus, day);
    }

    public EventResult calculateEventResult(Menus menus, int day) {
        return eventChecker.checkEvent(menus, day);
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        return eventChecker.calculateTotalBenefitAmount(menus, day);
    }

    public long calculateExpectedPaymentAmount() {
        return eventChecker.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public Badge calculateEventBadge() {
        return eventChecker.checkEventBadge();
    }


}
