package christmas.model;

import java.util.EnumMap;
import java.util.Map;

public class Order {

    private final Map<Menu, Integer> menus;

    public Order(Map<Menu, Integer> menus) {
        this.menus = menus;
    }

    public int calculateTotalOrderAmount() {
        return menus.keySet().stream().mapToInt(key -> menus.get(key) * Menu.valueOf(String.valueOf(key)).getPrice())
                .sum();
    }
}
