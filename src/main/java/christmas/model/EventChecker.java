package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventChecker {

    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    private EventResult eventResult;


    public EventResult checkEvent(Menus menus, int day) {
        return EventResult.createOf(
                List.of(checkGiveawayMenu(menus.totalOrderAmount()), checkWeekdayDiscount(menus, day),
                        checkWeekendDiscount(menus, day), checkSpecialDiscount(day), checkDdayDiscount(day)));
    }

    public long calculateTotalBenefitAmount(Menus menus, int day) {
        eventResult = checkEvent(menus, day);
        return eventResult.calculateTotalBenefit();
    }

    public long calculateExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public List<Long> checkEventResult() {
        return eventResult.getEventResult();
    }

    public Badge checkEventBadge(long totalBenefitAmount) {
        return eventResult.generateBadge(totalBenefitAmount);
    }


    public long checkGiveawayMenu(long totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return 1;
        }
        return 0;
    }


    public long checkWeekdayDiscount(Menus menus, int day) {
        if (day % 7 != 1 && day % 7 != 2) {
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


    public long checkSpecialDiscount(int day) {
        if (specialDay.contains(day)) {
            return 1;
        }
        return 0;
    }

    public long checkDdayDiscount(int day) {
        if (day > 25) {
            return 0L;
        }
        return day;

    }


}
