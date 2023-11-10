package christmas.model.Menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menus {

    private final Map<Menu, Integer> menus;

    public Menus(Map<Menu, Integer> menus) {
        this.menus = menus;
    }


    public static Menus of(Map<Menu, Integer> menus) {

        Arrays.stream(Menu.values()).forEach(menu -> menus.putIfAbsent(menu, 0));

        return new Menus(menus);
    }


    public int totalOrderAmount() {
        return Arrays.stream(Menu.values()).mapToInt(menu -> menus.get(menu)).sum();
    }

    public long totalDessertAmount() {
        return Arrays.stream(Menu.values()).filter(menu -> menu.getCategory().equals("디저트"))
                .mapToInt(key -> menus.get(key) / Menu.valueOf(
                        String.valueOf(key)).getPrice()).sum();
    }


    public Map<Menu, Integer> getMenus() {
        return this.menus;
    }


}
