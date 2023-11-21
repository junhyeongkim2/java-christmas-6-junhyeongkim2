package christmas.model;

import christmas.model.Menu.Menus;
import java.util.List;

public class EventChecker {

    private static final int EVENT_CREATE_CONDITION = 10000;
    private EventResult eventResult;

    public EventResult createEventResult(Menus menus, int day) {
        if (menus.totalOrderAmount() >= EVENT_CREATE_CONDITION) {
            return createContainedEventResult(menus, day);
        }
        return createEmptyEventResult();
    }

    // 행위 중심으로 생각
    // 만들어진 이벤트에 대한여 정상적으로 적용 됬는지, 할인을 적용 시킨 정보를 리스트를 만든다.
    // 메뉴에 정가가있을거고 그러면 그 정가에 대해서 만들어진 이벤트 정보를 통해서 할인 된 금액을 만들어내느거네
    //

    private EventResult createContainedEventResult(Menus menus, int day) {
        return eventResult = EventResult.createFrom(
                List.of(checkDdayDiscount(menus, day), checkWeekdayDiscount(menus, day),
                        checkWeekendDiscount(menus, day),
                        checkSpecialDiscount(menus, day), checkGiveawayMenu(menus, day)));
    }

    private EventResult createEmptyEventResult() {
        return eventResult = EventResult.createFrom(List.of());
    }


    public long checkTotalBenefitAmount() {
        return eventResult.calculateTotalBenefit();
    }

    public long checkExpectedPaymentAmount(long totalOrderAmount) {
        return eventResult.calculateExpectedPaymentAmount(totalOrderAmount);
    }

    public DiscountInfo checkDdayDiscount(Menus menus, int day) {
        return DiscountEvent.Dday().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkWeekdayDiscount(Menus menus, int day) {
        return DiscountEvent.Weekday().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkWeekendDiscount(Menus menus, int day) {
        return DiscountEvent.Weekend().calculateDiscountAmount(menus, day);
    }


    public DiscountInfo checkSpecialDiscount(Menus menus, int day) {
        return DiscountEvent.Special().calculateDiscountAmount(menus, day);
    }

    public DiscountInfo checkGiveawayMenu(Menus menus, int day) {
        return DiscountEvent.Giveaway().calculateDiscountAmount(menus, day);
    }

    public Badge checkEventBadge() {
        return eventResult.generateBadge();
    }


}
