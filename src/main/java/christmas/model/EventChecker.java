package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.Map;

public class EventChecker {
    public void checkEvent(Menus menus, int day) {
        checkGiveawayMenu(menus.totalOrderAmount());
        checkWeekdayDiscount(menus, day);
        checkWeekendDiscount(menus, day);
    }


    public Boolean checkGiveawayMenu(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return true;
        }
        return false;
    }


    public Long checkWeekdayDiscount(Menus menus, int day) {
        if (day % 7 != 1 && day % 7 != 2 && day % 7 != 3 && day != 25) {
            return menus.totalEventMatchAmount("디저트");
        }
        return 0L;
    }

    public Long checkWeekendDiscount(Menus menus, int day) {
        if (day % 7 == 1 || day % 7 == 2) {
            return menus.totalEventMatchAmount("메인");
        }
        return 0L;
    }


}
