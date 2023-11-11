package christmas.model;

import christmas.model.Menu.Menus;

public class Calculator {

    private int totalOrderAmount;

    private EventResult eventResult;


    public Integer calculateTotalOrderAmount(Menus menus) {
        totalOrderAmount = menus.totalOrderAmount();
        return totalOrderAmount;
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        EventChecker eventChecker = new EventChecker();
        eventResult = eventChecker.checkEvent(menus, day);
        return eventResult.calculateTotalBenefit();
    }

    public long calculateExpectedPaymentAmount(int totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }


}
