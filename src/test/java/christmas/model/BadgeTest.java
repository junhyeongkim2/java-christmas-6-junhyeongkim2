package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.SpecialEvent;
import christmas.model.Event.WeekdayEvent;
import christmas.model.Event.WeekendEvent;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {

    @DisplayName("별 배지 생성 테스트")
    @Test
    void createBadge_EqualStar_Success() {
        //given
        EventResult eventResult = EventResult.from(11, Order.of("아이스크림-3개"));
        //when
        Badge badge = Badge.from(eventResult.calculateTotalBenefit());
        //then
        assertThat(badge).isEqualTo(Badge.STAR);
    }


    @DisplayName("트리 배지 생성 테스트")
    @Test
    void createBadge_EqualTree_Success() {
        //given
        EventResult eventResult = EventResult.from(11, Order.of("아이스크림-5개"));
        //when
        Badge badge = Badge.from(eventResult.calculateTotalBenefit());
        //then
        assertThat(badge).isEqualTo(Badge.TREE);
    }


    @DisplayName("산타 배지 생성 테스트")
    @Test
    void createBadge_EqualSanta_Success() {
        //given
        EventResult eventResult = EventResult.from(15, Order.of("바비큐립-5개"));
        //when
        Badge badge = Badge.from(eventResult.calculateTotalBenefit());
        //then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @DisplayName("없음 배지 생성 테스트")
    @Test
    void createBadge_EqualNone_Success() {
        //given
        EventResult eventResult = EventResult.from(11, Order.of("아이스크림-1개"));
        //when
        Badge badge = Badge.from(eventResult.calculateTotalBenefit());
        //then
        assertThat(badge).isEqualTo(Badge.NONE);
    }

}
