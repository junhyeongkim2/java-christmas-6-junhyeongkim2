package christmas.model;

import christmas.model.Event.DiscountInfo;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;

public class Planner {

    Calculator calculator;

    public Planner() {
        this.calculator = new Calculator();
    }

    public Menus isContainMenu(String menuInput) {
        return Menu.createMenusFrom(menuInput);
    }

    public long requestTotalOrderAmount(Menus menus) {
        return calculator.calculateTotalOrderAmount(menus);
    }

    public DiscountInfo requestGiveawayMenuResult(Menus menus, int day) {
        return calculator.calculateGiveawayMenu(menus, day);
    }

    public EventResult requestEventResult(Menus menus, int day) {
        return calculator.calculateEventResult(menus, day);
    }

    public long requestTotalBenefitAmount(Menus menus, int day) {
        return calculator.calculateTotalBenefitAmount(menus, day);
    }

    public long requestExpectedPaymentAmount() {
        return calculator.calculateExpectedPaymentAmount();
    }

    public Badge requestBadge() {
        return calculator.calculateEventBadge();
    }


}
