package christmas.controller;

import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    public void start() {
        OutputView.printStartMessage();
        int visitDay = Integer.parseInt(InputView.readVisitDay());
        Order order = Order.of(InputView.readMenus());
        OutputView.printBenefitStartMessage(visitDay);
        OutputView.printMenus(order.toString());


    }

}
