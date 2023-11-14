package christmas.model.Menu;

import java.util.Arrays;
import java.util.Map;

public class Menus {

    private final Map<Menu, Integer> menus;

    public Menus(Map<Menu, Integer> menus) {
        this.menus = menus;
    }


    public static Menus from(Map<Menu, Integer> menus) {

        Arrays.stream(Menu.values()).forEach(menu -> menus.putIfAbsent(menu, 0));

        return new Menus(menus);
    }


    public Map<Menu, Integer> getMenus() {
        return this.menus;
    }


    public long totalOrderAmount() {
        return Arrays.stream(Menu.values()).mapToInt(menu -> menus.get(menu)).sum();
    }

    public long totalEventMatchAmount(String category) {
        return Arrays.stream(Menu.values()).filter(menu -> menu.getCategory().equals(category))
                .mapToInt(key -> menus.get(key) / Menu.valueOf(
                        String.valueOf(key)).getPrice()).sum();
    }


}
