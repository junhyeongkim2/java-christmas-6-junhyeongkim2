package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.GiveawayEvent;
import christmas.model.Event.SpecialEvent;
import christmas.model.Event.WeekdayEvent;
import christmas.model.Event.WeekendEvent;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EventPolicyTest {

    @DisplayName("크리스마스 이벤트 할인 테스트")
    @Test
    void discount_EqualChristmasDdayDiscountAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        menus.put(Menu.아이스크림, 5);
        EventPolicy christmasDdayEvent = new ChristmasDdayEvent(25,menus);
        //when
        int discountAmount = christmasDdayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(3400);
    }

    @DisplayName("평일 이벤트 할인 테스트")
    @Test
    void discount_EqualWeekdayDiscountAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        menus.put(Menu.아이스크림, 5);
        EventPolicy weekdayEvent = new WeekdayEvent(12,menus);
        //when
        int discountAmount = weekdayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(10115);
    }

    @DisplayName("주말 이벤트 할인 테스트")
    @Test
    void discount_EqualWeekendDiscountAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 6);
        menus.put(Menu.아이스크림, 5);
        menus.put(Menu.해산물파스타, 5);
        EventPolicy weekendEvent = new WeekendEvent(9,menus);
        //when
        int discountAmount = weekendEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(2023 * 11);
    }

    @DisplayName("특별 이벤트 할인 테스트")
    @Test
    void discount_EqualSepecailDiscountAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        EventPolicy specialEvent = new SpecialEvent(25,menus);
        //when
        int discountAmount = specialEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(1000);
    }

    @DisplayName("증정 이벤트 할인 테스트")
    @Test
    void discount_EqualGiveawayDiscountAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        menus.put(Menu.해산물파스타, 3);
        EventPolicy giveawayEvent = new GiveawayEvent(25,menus);
        //when
        int discountAmount = giveawayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(Menu.샴페인.getPrice());
    }


}
