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
    private static final String READ_VISITDAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String READ_MENUS_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String INVALID_VISITDAY_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final int MENU = 0;
    private static final int COUNT = 1;
    private static final int MAX_MENU_COUNT = 20;
    private static final int VALID_SPLIT = 2;

    private static final int VISITDAY_START = 1;
    private static final int VISITDAY_END = 31;

    public static String readVisitDay() {
        System.out.println(READ_VISITDAY_MESSAGE);
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
        System.out.println(READ_MENUS_MESSAGE);
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
            orderedMenu.putIfAbsent(Menu.valueOf(menuAndCount[MENU]),
                    Integer.parseInt(menuAndCount[COUNT]) * Menu.valueOf(menuAndCount[MENU]).getPrice());
        }
    }

    public static void validateIsUnderTwentyMenu(Map<Menu, Integer> orderedMenu) {
        int menuCount = orderedMenu.keySet().stream()
                .mapToInt(key -> orderedMenu.get(key) / Menu.valueOf(String.valueOf(key)).getPrice()).sum();
        if (menuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static void validateMenuAndCount(String[] menuAndCount, Map<Menu, Integer> orderedMenu) {
        validateSplit(menuAndCount);
        validateIsIntegerMenuCount(menuAndCount[COUNT]);
        validateIsContainMenu(menuAndCount[MENU]);
        validateIsOverOneMenu(Integer.parseInt(menuAndCount[COUNT]));
        validateDuplicatedMenu(orderedMenu, Menu.valueOf(menuAndCount[MENU]));
    }

    public static void validateSplit(String[] menuAndCount) {
        if (menuAndCount.length != VALID_SPLIT) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }

    }

    public static void validateIsDrinkOnlyMenu(Set<Menu> keySet) {
        if (keySet.stream().filter(key -> key.getCategory().equals(Menu.DRINK_CATEGORY)).count() == keySet.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static void validateDuplicatedMenu(Map<Menu, Integer> orderedMenu, Menu menu) {
        if (orderedMenu.get(menu) != null) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static void validateIsContainMenu(String menu) {
        Boolean find = Arrays.stream(Menu.values()).map(Menu::getName).collect(Collectors.toList()).contains(menu);
        if (find == false) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static void validateIsOverOneMenu(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static void validateIsIntegerMenuCount(String count) {
        try {
            Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    public static String validateMenuForm(String input) {
        if (!Pattern.matches(MENU_PATTERN, input)) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
        return input;
    }


    public static void validateInRange(String input) {
        int day = Integer.parseInt(input);
        if (day < VISITDAY_START || day > VISITDAY_END) {
            throw new IllegalArgumentException(INVALID_VISITDAY_MESSAGE);
        }
    }

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_VISITDAY_MESSAGE);
        }
    }


}
