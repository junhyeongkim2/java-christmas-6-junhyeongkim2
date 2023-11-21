package christmas.controller;

import christmas.model.Event.ChristmasEvent;
import christmas.model.Event.Event;
import christmas.model.Event.IDiscount;
import christmas.model.Event.WeekendDiscount;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;

public class ChristmasController {
    // 플래너
    // 이벤트 - 주어진 조건들에 대한 정보들

    private Planner planner;
    private Even


    public ChristmasController(Planner planner) {
        this.planner = planner;
    }

    public void start() {
        List<IDiscount> discountList = ArrayList<IDiscount>();
        discountList.add(WeekendDiscount)
                do
        Event event = ChristmasEvent(Menu(), discountList)
        OutputView.printStartChristmasPlannerMessage();
        printResult(Integer.parseInt(InputView.readVisitDay()), planner.isContainMenu(InputView.readMenus()));

    }

    private void printResult(int day, Menus menus) {
        printOrder(day, menus);
        printBenefit(day, menus);
    }

    private void printOrder(int day, Menus menus) {
        OutputView.printStartBenefitMessage(day);
        OutputView.printMenus(menus.getMenus());
        OutputView.printTotalOrderAmount(planner.requestTotalOrderAmount(menus));
    }

    private void printBenefit(int day, Menus menus) {
        OutputView.printGiveawayMenu(planner.requestGiveawayMenuResult(menus, day));
        OutputView.printEventResult(planner.requestEventResult(menus, day).getEventResult());
        OutputView.printTotalBenefitAmount(planner.requestTotalBenefitAmount());
        OutputView.printExpectedPaymentAmount(
                planner.requestExpectedPaymentAmount(planner.requestTotalOrderAmount(menus)));
        OutputView.printBadge(planner.requestBadge());
    }

}
