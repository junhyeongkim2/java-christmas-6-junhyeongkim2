package christmas.view;

import christmas.model.Badge;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menu;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat df = new DecimalFormat("###,###");

    public static void printStartChristmasPlannerMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printStartBenefitMessage(int day) {
        System.out.println("12월" + " " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenus(Map<Menu, Integer> menus) {
        System.out.println("<주문 메뉴>");
        menus.keySet().stream().filter(key -> menus.get(key) != 0).forEach(
                key -> System.out.println(
                        key + " " + menus.get(key) / Menu.valueOf(String.valueOf(key)).getPrice() + "개")
        );
        System.out.println();
    }

    public static void printTotalOrderAmount(long totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(replaceToDecimalFormat(totalOrderAmount) + "원\n");
    }


    public static void printGiveawayMenu(DiscountInfo giveawayMenu) {
        System.out.println("<증정 메뉴>");
        if (-giveawayMenu.getDiscount() == Menu.샴페인.getPrice()) {
            System.out.println("샴페인 1개\n");
        }
        if (giveawayMenu.getDiscount() == 0) {
            System.out.println("없음\n");
        }
    }

    public static void printEventResult(List<DiscountInfo> eventResult) {
        System.out.println("<혜택 내역>");
        if (eventResult.size() == 0) {
            System.out.println("없음\n");
            return;
        }
        eventResult.stream()
                .forEach(result -> System.out.println(
                        result.getName() + ": " + replaceToDecimalFormat(result.getDiscount()) + "원"));
        System.out.println();
    }

    public static void printTotalBenefitAmount(long totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println(replaceToDecimalFormat(+totalBenefitAmount) + "원\n");
    }

    public static void printExpectedPaymentAmount(long expectedPaymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(replaceToDecimalFormat(expectedPaymentAmount) + "원\n");
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    public static String replaceToDecimalFormat(long amount) {
        return df.format(amount);
    }


}


