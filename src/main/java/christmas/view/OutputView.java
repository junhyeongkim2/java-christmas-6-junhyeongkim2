package christmas.view;

import christmas.model.Badge;
import christmas.model.Event.EventType;
import christmas.model.Menu.Menu;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {


    public static void printStartBenefitMessage(int day) {
        System.out.println("12월" + " " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenus(Map<Menu, Integer> menus) {
        System.out.println("<주문 메뉴>");
        menus.keySet().stream().filter(key -> menus.get(key) != 0).forEach(
                key -> System.out.println(key + " " + menus.get(key) / Menu.valueOf(String.valueOf(key)).getPrice()+"개")
        );
        System.out.println();
    }

    public static void printTotalOrderAmount(long totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalOrderAmount + "원\n");
    }


    public static void printGiveawayMenu(EventType giveawayMenu) {
        System.out.println("<증정 메뉴>");
        if (giveawayMenu.getDiscount()==Menu.샴페인.getPrice()) {
            System.out.println("샴페인 1개\n");
        }
        if (giveawayMenu.getDiscount() == 0) {
            System.out.println("없음\n");
        }
    }

    public static void printEventResult(List<EventType> eventResult) {
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: -" + eventResult.get(4)+"원");
        isWeekedayOrWeekend(eventResult.get(1).getDiscount(), eventResult.get(2).getDiscount());
        System.out.println("특별 할인: -" + eventResult.get(3)+"원");
        System.out.println("증정 이벤트: -" + eventResult.get(0)+"원");
        System.out.println();
    }

    public static void isWeekedayOrWeekend(long weekday, long weekend) {
        if (weekday != 0) {
            System.out.println("평일 할인: -" + weekday+"원");
        }
        if (weekend != 0) {
            System.out.println("주말 할인: -" + weekend+"원");
        }
    }

    public static void printTotalBenefitAmount(long totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + totalBenefitAmount+"원\n");
    }

    public static void printExpectedPaymentAmount(long expectedPaymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(expectedPaymentAmount+"원\n");
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }


}


