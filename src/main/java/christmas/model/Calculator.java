package christmas.model;

import christmas.model.Menu.Menus;

public class Calculator {

    private int totalOrderAmount;

    public Integer calculateTotalOrderAmount(Menus menus) {
        totalOrderAmount = menus.totalOrderAmount();
        return totalOrderAmount;
    }


    public void calculateTotalBenefitAmount(Menus menus, int day) {
        EventChecker eventChecker = new EventChecker();
        eventChecker.checkEvent(menus, day);
    }
}
