package christmas.model;

import christmas.model.Menu.Menus;
import java.util.List;

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

    public long calculateGiveawayMenu() {
        return eventChecker.checkGiveawayMenu(totalOrderAmount);
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
