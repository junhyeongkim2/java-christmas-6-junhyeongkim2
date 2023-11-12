package christmas.controller;

import christmas.model.Calculator;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    private Planner planner;
    int day;
    Menus menus;

    public ChristmasController(Planner planner) {
        this.planner = planner;
    }

    public void start() {
        OutputView.printStartChristmasPlannerMessage();
        day = Integer.parseInt(InputView.readVisitDay());
        try {
            menus = planner.isContainMenu(InputView.readMenus());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            planner.isContainMenu(InputView.readMenus());
        }
        OutputView.printStartBenefitMessage(day);
        OutputView.printMenus(menus.getMenus());
        OutputView.printTotalOrderAmount(planner.requestTotalOrderAmount(menus));
        OutputView.printGiveawayMenu(planner.requestGiveawayMenuResult(menus, day));
        OutputView.printEventResult(planner.requestEventResult(menus, day).getEventResult());
        OutputView.printTotalBenefitAmount(planner.requestTotalBenefitAmount(menus, day));
        OutputView.printExpectedPaymentAmount(planner.requestExpectedPaymentAmount());
        OutputView.printBadge(planner.requestBadge());
    }

}
