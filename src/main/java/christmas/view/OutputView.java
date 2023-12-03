package christmas.view;

import christmas.model.Badge;
import christmas.model.EventResult;
import christmas.model.Menu;
import java.text.DecimalFormat;

public class OutputView {

    public final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");

    public static void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitStartMessage(int visitDay) {
        System.out.println("12월 " + visitDay + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenus(String menus) {
        System.out.println(menus);
    }

    public static void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>\n" + DECIMAL_FORMAT.format(totalOrderAmount) + "원\n");
    }

    public static void printIsGiveaway(Menu giveaway) {
        System.out.println("<증정 메뉴>");
        if (giveaway.equals(Menu.없음)) {
            System.out.println(Menu.없음 + "\n");
        }
        if (!giveaway.equals(Menu.없음)) {
            System.out.println(giveaway + "\n");
        }
    }

    public static void printWinningEvents(EventResult eventResult) {
        System.out.println("<혜택 내역>");
        if (eventResult.toString().equals("")) {
            System.out.println("없음\n");
            return;
        }
        System.out.println(eventResult.toString());
    }

    public static void printTotalBenefitAmount(int calculateTotalBenefit) {
        System.out.println("<총혜택 금액>\n" + DECIMAL_FORMAT.format(calculateTotalBenefit) + "원\n");
    }

    public static void printExpectedPaymentAmount(int calcualteExpectedPaymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>\n" + DECIMAL_FORMAT.format(calcualteExpectedPaymentAmount) + "원\n");
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>\n" + badge.getName());
    }
}
