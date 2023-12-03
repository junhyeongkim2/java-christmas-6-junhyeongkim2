package christmas.model;

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
        return new Order(menus);
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


}
