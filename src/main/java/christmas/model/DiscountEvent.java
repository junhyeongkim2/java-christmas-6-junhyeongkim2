package christmas.model;

import christmas.model.Event.Dday;
import christmas.model.Event.Giveaway;
import christmas.model.Event.Special;
import christmas.model.Event.Weekday;
import christmas.model.Event.Weekend;
import christmas.model.Menu.Menus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountEvent {

    public static DiscountEvent createDday() {
        return new Dday();
    }

    public static DiscountEvent createGiveaway() {
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

    public int calculateDiscountAmount(Menus menus, int day) {
        return 0;
    }

    abstract protected int getDiscountAmount();

    abstract protected int isSatisfiedBy(Menus menus, int day);

    abstract protected int isSatisfiedBy(int day);


}
