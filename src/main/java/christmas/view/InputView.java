package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu.Menu;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String MENU_PATTERN = "([\\w\\S]+-\\d+,)*[\\w\\S]+-\\d+";

    public static String readVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return repeatReadVisitDay();
    }

    private static String repeatReadVisitDay() {
        try {
            String input = Console.readLine();
            validateIsInteger(input);
            validateInRange(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readVisitDay();
        }
    }

    public static Map<Menu, Integer> readMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return repeatReadMenus();
    }

    private static Map<Menu, Integer> repeatReadMenus() {
        try {
            return splitMenuAndCount(splitMenuWithComma(validateMenuForm(Console.readLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMenus();
        }
    }


    public static String[] splitMenuWithComma(String menuInput) {
        return menuInput.split(",");
    }

    public static String[] splitMenuWithHypen(String menuInput) {
        return menuInput.split("-");
    }

    public static Map<Menu, Integer> splitMenuAndCount(String[] splitMenuWithComma) {
        Map<Menu, Integer> orderedMenu = new EnumMap(Menu.class);
        validateSplitMenu(splitMenuWithComma, orderedMenu);
        validateIsDrinkOnlyMenu(orderedMenu.keySet());
        validateIsUnderTwentyMenu(orderedMenu);
        return orderedMenu;
    }

    private static void validateSplitMenu(String[] splitMenuWithComma, Map<Menu, Integer> orderedMenu) {
        for (String splitMenu : splitMenuWithComma) {
            String[] menuAndCount = splitMenuWithHypen(splitMenu);
            validateMenuAndCount(splitMenuWithHypen(splitMenu), orderedMenu);
            orderedMenu.putIfAbsent(Menu.valueOf(menuAndCount[0]),
                    Integer.parseInt(menuAndCount[1]) * Menu.valueOf(menuAndCount[0]).getPrice());
        }
    }

    public static void validateIsUnderTwentyMenu(Map<Menu, Integer> orderedMenu) {
        int menuCount = orderedMenu.keySet().stream()
                .mapToInt(key -> orderedMenu.get(key) / Menu.valueOf(String.valueOf(key)).getPrice()).sum();
        if (menuCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateMenuAndCount(String[] menuAndCount, Map<Menu, Integer> orderedMenu) {
        validateSplit(menuAndCount);
        validateIsIntegerMenuCount(menuAndCount[1]);
        validateIsContainMenu(menuAndCount[0]);
        validateIsOverOneMenu(Integer.parseInt(menuAndCount[1]));
        validateDuplicatedMenu(orderedMenu, Menu.valueOf(menuAndCount[0]));
    }

    public static void validateSplit(String[] menuAndcount) {
        if (menuAndcount.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }

    public static void validateIsDrinkOnlyMenu(Set<Menu> keySet) {
        if (keySet.stream().filter(key -> key.getCategory().equals("음료")).count() == keySet.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateDuplicatedMenu(Map<Menu, Integer> orderedMenu, Menu menu) {
        if (orderedMenu.get(menu) != null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsContainMenu(String menu) {
        Boolean find = Arrays.stream(Menu.values()).map(Menu::getName).collect(Collectors.toList()).contains(menu);
        if (find == false) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateIsOverOneMenu(int count) {
        if (count < 1) {
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

    public static String validateMenuForm(String input) {
        if (!Pattern.matches(MENU_PATTERN, input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return input;
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
