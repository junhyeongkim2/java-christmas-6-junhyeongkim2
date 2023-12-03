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
        EventPolicy christmasDdayEvent = new ChristmasDdayEvent(25, Order.of("레드와인-3개,바비큐립-5개,아이스크림-5개"));
        //when
        int discountAmount = christmasDdayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(-3400);
    }

    @DisplayName("평일 이벤트 할인 테스트")
    @Test
    void discount_EqualWeekdayDiscountAmount_Success() {
        //given
        EventPolicy weekdayEvent = new WeekdayEvent(12, Order.of("레드와인-3개,바비큐립-5개,아이스크림-5개"));
        //when
        int discountAmount = weekdayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(-10115);
    }

    @DisplayName("주말 이벤트 할인 테스트")
    @Test
    void discount_EqualWeekendDiscountAmount_Success() {
        //given
        EventPolicy weekendEvent = new WeekendEvent(9, Order.of("레드와인-3개,바비큐립-6개,아이스크림-5개,해산물파스타-5개"));
        //when
        int discountAmount = weekendEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(-(2023 * 11));
    }

    @DisplayName("특별 이벤트 할인 테스트")
    @Test
    void discount_EqualSepecailDiscountAmount_Success() {
        //given
        EventPolicy specialEvent = new SpecialEvent(25, Order.of("레드와인-3개"));
        //when
        int discountAmount = specialEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(-1000);
    }

    @DisplayName("증정 이벤트 할인 테스트")
    @Test
    void discount_EqualGiveawayDiscountAmount_Success() {
        //given
        EventPolicy giveawayEvent = new GiveawayEvent(16, Order.of("레드와인-3개,바비큐립-5개,해산물파스타-3개"));
        //when
        int discountAmount = giveawayEvent.discount();
        //then
        assertThat(discountAmount).isEqualTo(-Menu.샴페인.getPrice());
    }


}
