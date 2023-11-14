package christmas.view;

import christmas.model.Badge;
import christmas.model.DiscountInfo;
import christmas.model.Menu.Menu;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat df = new DecimalFormat("###,###");
    private static final String START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DECEMBER = "12월";
    private static final String START_BENEFIT_MESSAGE = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String COUNT = "개";
    private static final String SPACE = " ";
    private static final String TOTAL_ORDER_AMOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String WON = "원";
    private static final String GIVEAWAY_MESSAGE = "<증정 메뉴>";
    private static final String CHAMPAGNE_MESSAGE = "샴페인 1개";
    private static final String NONE_MESSAGE = "없음";
    private static final String BENEFIT_LIST_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_MESSAGE = "<총혜택 금액>";
    private static final String EXPECTED_PAYMENT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";


    public static void printStartChristmasPlannerMessage() {
        System.out.println(START_PLANNER_MESSAGE);
    }

    public static void printStartBenefitMessage(int day) {
        System.out.println(DECEMBER + " " + day + START_BENEFIT_MESSAGE);
    }

    public static void printMenus(Map<Menu, Integer> menus) {
        System.out.println(ORDER_MENU);
        menus.keySet().stream().filter(key -> menus.get(key) != 0).forEach(
                key -> System.out.println(
                        key + SPACE + menus.get(key) / Menu.valueOf(String.valueOf(key)).getPrice() + COUNT)
        );
        System.out.println();
    }

    public static void printTotalOrderAmount(long totalOrderAmount) {
        System.out.println(TOTAL_ORDER_AMOUNT_MESSAGE);
        System.out.println(replaceToDecimalFormat(totalOrderAmount) + WON + "\n");
    }


    public static void printGiveawayMenu(DiscountInfo giveawayMenu) {
        System.out.println(GIVEAWAY_MESSAGE);
        if (-giveawayMenu.getDiscount() == Menu.샴페인.getPrice()) {
            System.out.println(CHAMPAGNE_MESSAGE + "\n");
        }
        if (giveawayMenu.getDiscount() == 0) {
            System.out.println(NONE_MESSAGE + "\n");
        }
    }

    public static void printEventResult(List<DiscountInfo> eventResult) {
        System.out.println(BENEFIT_LIST_MESSAGE);
        if (eventResult.size() == 0) {
            System.out.println(NONE_MESSAGE + "\n");
            return;
        }
        eventResult.stream()
                .forEach(result -> System.out.println(
                        result.getName() + ": " + replaceToDecimalFormat(result.getDiscount()) + WON));
        System.out.println();
    }

    public static void printTotalBenefitAmount(long totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_MESSAGE);
        System.out.println(replaceToDecimalFormat(+totalBenefitAmount) + WON + "\n");
    }

    public static void printExpectedPaymentAmount(long expectedPaymentAmount) {
        System.out.println(EXPECTED_PAYMENT_MESSAGE);
        System.out.println(replaceToDecimalFormat(expectedPaymentAmount) + WON + "\n");
    }

    public static void printBadge(Badge badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge);
    }

    public static String replaceToDecimalFormat(long amount) {
        return df.format(amount);
    }


}


