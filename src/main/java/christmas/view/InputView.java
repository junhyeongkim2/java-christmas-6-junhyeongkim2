package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class InputView {

    public static String readVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateIsNumber(input);
        return input;
    }

    public static String readMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        return input;
    }

    public static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsInRange(String input) {
        int visitDay = Integer.parseInt(input);
        if (visitDay < 1 || visitDay > 31) {
            throw new IllegalArgumentException();
        }
    }


}
