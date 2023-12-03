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
        EventResult eventResult = new EventResult(
                List.of(new ChristmasDdayEvent(25, new EnumMap<Menu, Integer>(Menu.class)),
                        new WeekdayEvent(25, new EnumMap<Menu, Integer>(Menu.class))));
        //when
        List<EventPolicy> events = eventResult.getEvents();
        //then
        assertThat(events.size()).isEqualTo(2);
        assertThat(events.get(0).getEventInfo()).isEqualTo(EventInfo.CHRISTMAS_D_DAY_EVENT);
        assertThat(events.get(1).getEventInfo()).isEqualTo(EventInfo.WEEKDAY_EVENT);
    }

    @DisplayName("총 혜택 금액 계산 테스트")
    @Test
    void calculateTotalBenefit_EqualBenefit_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        menus.put(Menu.아이스크림, 2);
        EventResult eventResult = new EventResult(
                List.of(new ChristmasDdayEvent(25, menus), new WeekdayEvent(25, menus)));
        //when
        int totalBenefit = eventResult.calculateTotalBenefit();
        //then
        assertThat(totalBenefit).isEqualTo(3400 + 2023 * 2);

    }


}
