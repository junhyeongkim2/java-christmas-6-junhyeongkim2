package christmas.view;

import christmas.model.Menu;

public class OutputView {

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
        System.out.println("<할인 전 총주문 금액>\n" + totalOrderAmount + "원");
    }

    public static void printIsGiveaway(Menu giveaway) {
        System.out.println("<증정 메뉴>");
        if (giveaway.equals(Menu.없음)) {
            System.out.println(Menu.없음);
        }
        if (!giveaway.equals(Menu.없음)) {
            System.out.println(giveaway);
        }
    }
}
