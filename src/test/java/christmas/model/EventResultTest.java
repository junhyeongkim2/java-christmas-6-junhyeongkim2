package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.EventInfo;
import christmas.model.Event.WeekdayEvent;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventResultTest {

    @DisplayName("이벤트 결과 생성 테스트")
    @Test
    void createResult_EqualResult_Success() {
        //given
        EventResult eventResult = EventResult.from(25, Order.of("아이스크림-3개"));
        //when
        List<EventPolicy> events = eventResult.getEvents();
        //then
        assertThat(events.size()).isEqualTo(5);
        assertThat(events.get(0).getEventInfo()).isEqualTo(EventInfo.CHRISTMAS_D_DAY_EVENT);
        assertThat(events.get(1).getEventInfo()).isEqualTo(EventInfo.WEEKDAY_EVENT);
        assertThat(events.get(2).getEventInfo()).isEqualTo(EventInfo.WEEKEND_EVENT);
        assertThat(events.get(3).getEventInfo()).isEqualTo(EventInfo.SPECIAL_EVENT);
        assertThat(events.get(4).getEventInfo()).isEqualTo(EventInfo.GIVEAWAY_EVENT);
    }

    @DisplayName("총 혜택 금액 계산 테스트")
    @Test
    void calculateTotalBenefit_EqualBenefit_Success() {
        //given
        EventResult eventResult = EventResult.from(25, Order.of("레드와인-3개,바비큐립-5개,아이스크림-2개"));
        //when
        int totalBenefit = eventResult.calculateTotalBenefit();
        //then
        assertThat(totalBenefit).isEqualTo(-3400 + -2023 * 2 + -1000 + -Menu.샴페인.getPrice());

    }


}
