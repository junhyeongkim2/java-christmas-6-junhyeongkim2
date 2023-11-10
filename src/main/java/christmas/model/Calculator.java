package christmas.model;

import christmas.model.Menu.Menus;

public class Calculator {

    private int totalOrderAmount;


    public Integer calculateTotalOrderAmount(Menus menus) {
        totalOrderAmount = menus.totalOrderAmount();
        return totalOrderAmount;
    }


    public long calculateTotalBenefitAmount(Menus menus, int day) {
        EventChecker eventChecker = new EventChecker();
        EventResult eventresult = eventChecker.checkEvent(menus, day);
        return eventresult.calculateTotalBenefit();
    }
}
