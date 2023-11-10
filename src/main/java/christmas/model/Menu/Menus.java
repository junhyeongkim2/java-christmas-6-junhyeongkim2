package christmas.model.Menu;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public int totalOrderAmount() {
        return menus.stream().mapToInt(Menu::getPrice).sum();
    }

}
