package christmas.model;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import java.util.List;

public class Calculator {
    public Integer calculateTotalOrderAmount(Menus menus) {
        return menus.totalOrderAmount();
    }


}
