package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.List;
import java.util.Map;

public class EventChecker {

    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    public void checkEvent(Menus menus, int day) {
        checkGiveawayMenu(menus.totalOrderAmount());
        checkWeekdayDiscount(menus, day);
        checkWeekendDiscount(menus, day);
        checkSpecialDiscount(day);
        checkDdayDiscount(day);
    }


    public Boolean checkGiveawayMenu(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return true;
        }
        return false;
    }


    public long checkWeekdayDiscount(Menus menus, int day) {
        if (day % 7 != 1 && day % 7 != 2 && day % 7 != 3 && day != 25) {
            return menus.totalEventMatchAmount("디저트");
        }
        return 0;
    }

    public long checkWeekendDiscount(Menus menus, int day) {
        if (day % 7 == 1 || day % 7 == 2) {
            return menus.totalEventMatchAmount("메인");
        }
        return 0;
    }


    public Boolean checkSpecialDiscount(int day) {
        if (specialDay.contains(day)) {
            return true;
        }
        return false;
    }

    public long checkDdayDiscount(int day) {
        if (day > 25) {
            return 0L;
        }
        return day;

    }
}
