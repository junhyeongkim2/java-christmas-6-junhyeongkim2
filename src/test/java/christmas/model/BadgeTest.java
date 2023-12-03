package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.SpecialEvent;
import christmas.model.Event.WeekdayEvent;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {

    @DisplayName("별 배지 생성 테스트")
    @Test
    void createBadge_EqualStart_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<Menu, Integer>(Menu.class);
        menus.put(Menu.아이스크림, 3);
        EventResult eventResult = new EventResult(
                List.of(new WeekdayEvent(11, menus)));
        //when
        Badge badge = Badge.from(eventResult.calculateTotalBenefit());
        //then
        assertThat(badge).isEqualTo(Badge.STAR);
    }


}
