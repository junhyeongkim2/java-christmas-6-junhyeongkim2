package christmas.view;

import christmas.model.Menu.Menu;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printTotalOrderAmount(int totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalOrderAmount + "원");
    }

    public static void printMenus(Map<Menu, Integer> menus) {
        System.out.println("<주문 메뉴>");
        menus.keySet().stream().filter(key -> menus.get(key) != 0).forEach(
                key -> System.out.println(key + " " + menus.get(key) / Menu.valueOf(String.valueOf(key)).getPrice())
        );
        System.out.println();
    }


    public static void printGiveawayMenu(Boolean giveawayMenu) {
        System.out.println("<증정 메뉴>");
        if (giveawayMenu == true) {
            System.out.println("샴페인");
        }
        if (giveawayMenu == false) {
            System.out.println("없음");
        }
    }

    public static void printEventResult(List<Long> eventResult) {
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: -" + eventResult.get(4));
        isWeekedayOrWeekend(eventResult.get(1), eventResult.get(2));
        System.out.println("특별 할인: -" + eventResult.get(3));
        System.out.println("증정 이벤트: -" + eventResult.get(0));
    }

    public static void isWeekedayOrWeekend(long weekday, long weekend) {
        if (weekday != 0) {
            System.out.println("평일 할인: -" + weekday);
        }
        if (weekend != 0) {
            System.out.println("주말 할인: -" + weekend);
        }
    }
}


