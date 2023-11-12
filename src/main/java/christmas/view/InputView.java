package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class InputView {

    public static String readVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        try {
            validateIsInteger(input);
            validateInRange(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readVisitDay();
        }
        return input;
    }

    public static Map<Menu, Integer> readMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return splitMenuAndCount(splitMenuWithComma(Console.readLine()));
    }


    public static String[] splitMenuWithComma(String menuInput) {
        return menuInput.split(",");
    }

    public static String[] splitMenuWithHypen(String menuInput) {
        return menuInput.split("-");
    }

    public static Map<Menu, Integer> splitMenuAndCount(String[] splitMenuWithComma) {
        Map<Menu, Integer> orderedMenu = new EnumMap(Menu.class);
        int menuCount = 0;
        try {
            for (String splitMenu : splitMenuWithComma) {
                String[] menuAndCount = splitMenuWithHypen(splitMenu);
                validateIsIntegerMenuCount(menuAndCount[1]);
                validateIsContainMenu(menuAndCount[0]);
                validateIsUnderTwentyMenu(menuCount);
                validateIsOverOneMenu(Integer.parseInt(menuAndCount[1]));
                menuCount += Integer.parseInt(menuAndCount[1]);
                orderedMenu.putIfAbsent(Menu.valueOf(menuAndCount[0]),
                        Integer.parseInt(menuAndCount[1]) * Menu.valueOf(menuAndCount[0]).getPrice());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMenus();
        }

        return orderedMenu;
    }

    public static void validateIsContainMenu(String menu) {
        Boolean find = Arrays.stream(Menu.values()).map(Menu::getName).collect(Collectors.toList()).contains(menu);
        if (find == false) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsUnderTwentyMenu(int count) {
        if (count > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsOverOneMenu(int count) {
        if (count <= 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsIntegerMenuCount(String count) {
        try {
            Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


    public static void validateInRange(String input) {
        int day = Integer.parseInt(input);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


}
