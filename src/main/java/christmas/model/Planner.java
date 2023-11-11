package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.List;

public class Planner {

    Calculator calculator;

    public Planner(Calculator calculator) {
        this.calculator = calculator;
    }

    public Menus isContainMenu(String menuInput) {
        return Menu.splitMenuWithNameAndCount(menuInput);
    }

    public long requestTotalOrderAmount(Menus menus) {
        return calculator.calculateTotalOrderAmount(menus);
    }

    public long requestGiveawayMenuResult() {
        return calculator.calculateGiveawayMenu();
    }

    public EventResult requestEventResult(Menus menus, int day) {
        return calculator.calculateEventResult(menus,day);
    }

    public long requestTotalBenefitAmount(Menus menus, int day) {
        return calculator.calculateTotalBenefitAmount(menus, day);
    }

    public long requestExpectedPaymentAmount() {
        return calculator.calculateExpectedPaymentAmount();
    }

    public Badge requestBadge(long totalBenefitAmount) {
        return calculator.calculateEventBadge(totalBenefitAmount);
    }


}
