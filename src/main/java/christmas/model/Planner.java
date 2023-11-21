package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.Map;

public class Planner {

    private Calculator calculator;

    public Planner() {
        this.calculator = new Calculator();
    }

    public Menus isContainMenu(Map<Menu, Integer> orderedMenu) {
        return Menus.from(orderedMenu);
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

    public long requestTotalBenefitAmount() {
        return calculator.calculateTotalBenefitAmount();
    }

    public long requestExpectedPaymentAmount(long totalOrderAmount) {
        return calculator.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public Badge requestBadge() {
        return calculator.calculateEventBadge();
    }


}
