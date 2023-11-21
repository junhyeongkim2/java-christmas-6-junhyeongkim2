package christmas.model;

import christmas.model.Event.Dday;
import christmas.model.Event.Giveaway;
import christmas.model.Event.Special;
import christmas.model.Event.Weekday;
import christmas.model.Event.Weekend;
import christmas.model.Menu.Menus;

public abstract class DiscountEvent {

    public static final int ZERO_DISCOUNT = 0;
    protected static final int SEVENDAYS = 7;
    protected static final int WEEKEND_ONE = 1;
    protected static final int WEEKEND_TWO = 2;

    public static DiscountEvent Dday() {
        return new Dday();
    }

    public static DiscountEvent Giveaway() {
        return new Giveaway();
    }

    public static DiscountEvent Special() {
        return new Special();
    }

    public static DiscountEvent Weekday() {
        return new Weekday();
    }

    public static DiscountEvent Weekend() {
        return new Weekend();
    }


    abstract protected DiscountInfo calculateDiscountAmount(Menus menus, int day);


}
