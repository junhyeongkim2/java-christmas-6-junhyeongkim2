package christmas.controller;

import christmas.model.EventResult;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class EventPlannerController {
    public void start() {
        OutputView.printStartMessage();
        int visitDay = repeatUntilValid(() -> Integer.parseInt(InputView.readVisitDay()));
        Order order = printOrderInfo(visitDay);
        printEventResult(visitDay, order);
    }

    private void printEventResult(int visitDay, Order order) {
        EventResult eventResult = EventResult.from(visitDay, order);
        OutputView.printWinningEvents(eventResult);
        OutputView.printTotalBenefitAmount(eventResult.calculateTotalBenefit());
        OutputView.printExpectedPaymentAmount(eventResult.calcualteExpectedPaymentAmount());
        OutputView.printBadge(eventResult.calculateBadge());
    }

    private Order printOrderInfo(int visitDay) {
        Order order = repeatUntilValid(() -> Order.of(InputView.readMenus()));
        OutputView.printBenefitStartMessage(visitDay);
        OutputView.printMenus(order.toString());
        OutputView.printTotalOrderAmount(order.calculateTotalOrderAmount());
        OutputView.printIsGiveaway(order.isGiveaway());
        return order;
    }


    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(function);
        }
    }

}
