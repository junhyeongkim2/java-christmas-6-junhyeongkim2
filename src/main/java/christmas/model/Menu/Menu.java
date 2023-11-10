package christmas.model.Menu;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public enum Menu {

    양송이수프("양송이수프", "에피타이저", 6000),
    타파스("타파스", "에피타이저", 5500),
    시저샐러드("시저샐러드", "에피타이저", 8000),
    티본스테이크("티본스테이크", "메인", 55000),
    바비큐립("바비큐립", "메인", 54000),
    크리스마스파스타("크리스마스파스타", "메인", 25000),
    초코케이크("초코케이크", "디저트", 15000),
    아이스크림("아이스크림", "디저트", 5000),
    제로콜라("제로콜라", "음료", 3000),
    레드와인("레드와인", "음료", 60000),
    샴페인("샴페인", "음료", 25000);

    private final String name;
    private final String category;
    private final int price;

    Menu(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static void validateIsContainMenu(String menu) {
        Boolean find = Arrays.stream(Menu.values()).map(Menu::getName).collect(Collectors.toList()).contains(menu);
        if (find == false) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static Menus splitMenuWithNameAndCount(String menuInput) {
        return splitMenuAndCount(splitMenuWithComma(menuInput));
    }

    public static String[] splitMenuWithComma(String menuInput) {
        return menuInput.split(",");
    }

    public static String[] splitMenuWithHypen(String menuInput) {
        return menuInput.split("-");
    }

    public static Menus splitMenuAndCount(String[] splitMenuWithComma) {
        Map<Menu, Integer> orderedMenu = new EnumMap(Menu.class);
        for (String splitMenu : splitMenuWithComma) {
            String[] menuAndCount = splitMenuWithHypen(splitMenu);
            Menu.validateIsContainMenu(menuAndCount[0]);
            orderedMenu.putIfAbsent(Menu.valueOf(menuAndCount[0]),
                    Integer.parseInt(menuAndCount[1]) * Menu.valueOf(menuAndCount[0]).getPrice());
        }
        return Menus.of(orderedMenu);
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }


}
