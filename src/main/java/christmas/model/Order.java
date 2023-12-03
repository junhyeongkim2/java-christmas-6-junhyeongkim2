package christmas.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {

    private final Map<Menu, Integer> menus;

    private Order(Map<Menu, Integer> menus) {
        this.menus = menus;
    }

    public static Order of(String input) {
        Map<Menu, Integer> menus = new EnumMap<Menu, Integer>(Menu.class);
        Matcher matcher = getMenuMatcher(input);
        createMenusWithMatcher(menus, matcher);
        validateOnlyDrink(menus);
        validateIsOverTwentyMenu(menus);
        validateIsExistMenu(menus);
        return new Order(menus);
    }

    private static void validateIsExistMenu(Map<Menu, Integer> menus) {
        if (menus.keySet().stream().allMatch(key -> key.isContain())) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsOverTwentyMenu(Map<Menu, Integer> menus) {
        if (menus.values().stream().mapToInt(value -> value.intValue()).sum() > 20) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOnlyDrink(Map<Menu, Integer> menus) {
        if (menus.keySet().stream().allMatch(Menu::isDrink)) {
            throw new IllegalArgumentException();
        }
    }


    private static void createMenusWithMatcher(Map<Menu, Integer> menus, Matcher matcher) {
        while (matcher.find()) {
            String menuName = matcher.group(1);
            int quantity = Integer.parseInt(matcher.group(2));
            menus.put(Menu.valueOf(menuName), quantity);
        }
    }

    private static Matcher getMenuMatcher(String input) {
        Pattern pattern = Pattern.compile("(\\p{IsHangul}+)-(\\d+)");
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    public int calculateTotalOrderAmount() {
        return menus.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<주문 메뉴>\n");

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            String menuName = String.valueOf(entry.getKey()); // 메뉴 이름 가져오기
            int quantity = entry.getValue(); // 메뉴 개수 가져오기
            sb.append(menuName).append(" ").append(quantity).append("개\n");
        }
        return sb.toString();
    }

    public Menu isGiveaway() {
        if (calculateTotalOrderAmount() >= 120000) {
            return Menu.샴페인;
        }
        return Menu.없음;
    }


    public int calculateTotalDessertOrderAmount() {
        return menus.keySet().stream().filter(key -> Menu.valueOf(String.valueOf(key)).isDessert())
                .mapToInt(key -> menus.get(key)).sum();
    }

    public int calculateTotalMainOrderAmount() {
        return menus.keySet().stream().filter(key -> Menu.valueOf(String.valueOf(key)).isMain())
                .mapToInt(key -> menus.get(key)).sum();
    }
}
