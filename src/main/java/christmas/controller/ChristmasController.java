package christmas.controller;

import christmas.model.Calculator;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    private Planner planner;


    public ChristmasController(Planner planner) {
        this.planner = planner;
    }

    public void start() {
        OutputView.printStartChristmasPlannerMessage();
        printResult(Integer.parseInt(InputView.readVisitDay()), planner.isContainMenu(InputView.readMenus()));

    }

    public void printResult(int day, Menus menus) {
        printOrder(day, menus);
        printBenefit(day, menus);
    }

    public void printOrder(int day, Menus menus) {
        OutputView.printStartBenefitMessage(day);
        OutputView.printMenus(menus.getMenus());
        OutputView.printTotalOrderAmount(planner.requestTotalOrderAmount(menus));
    }

    public void printBenefit(int day, Menus menus) {
        OutputView.printGiveawayMenu(planner.requestGiveawayMenuResult(menus, day));
        OutputView.printEventResult(planner.requestEventResult(menus, day).getEventResult());
        OutputView.printTotalBenefitAmount(planner.requestTotalBenefitAmount());
        OutputView.printExpectedPaymentAmount(
                planner.requestExpectedPaymentAmount(planner.requestTotalOrderAmount(menus)));
        OutputView.printBadge(planner.requestBadge());
    }

}
