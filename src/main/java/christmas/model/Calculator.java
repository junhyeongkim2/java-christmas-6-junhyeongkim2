package christmas.model;

import christmas.model.Menu.Menus;

public class Calculator {

    private int totalOrderAmount;

    private EventChecker eventChecker;

    public Calculator() {
        this.eventChecker = new EventChecker();
    }


    public Integer calculateTotalOrderAmount(Menus menus) {
        totalOrderAmount = menus.totalOrderAmount();
        return totalOrderAmount;
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        return eventChecker.calculateTotalBenefitAmount(menus, day);
    }

    public long calculateExpectedPaymentAmount(int totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }


}
