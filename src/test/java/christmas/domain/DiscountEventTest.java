package christmas.domain;

import christmas.model.DiscountEvent;
import christmas.model.Event.EventType;
import christmas.model.Event.Giveaway;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountEventTest {

    @DisplayName("DiscountEvent 테스트")
    @Test
    void discountEventTest() {

        Planner planner = new Planner();
        Menus menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,제로콜라-1")));
        int day = 6;


    }

}
