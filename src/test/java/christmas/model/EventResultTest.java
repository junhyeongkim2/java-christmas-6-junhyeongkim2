package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import christmas.model.Event.WeekdayEvent;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventResultTest {

    @DisplayName("이벤트 결과 생성 테스트")
    @Test
    void createResult_EqualResult_Success() {
        //given
        EventResult eventResult = new EventResult(
                List.of(new ChristmasDdayEvent("event1"), new WeekdayEvent("event2")));
        //when
        List<EventPolicy> events = eventResult.getEvents();
        //then
        assertThat(events.size()).isEqualTo(2);
        assertThat(events.get(0).getName()).isEqualTo("event1");
        assertThat(events.get(1).getName()).isEqualTo("event2");

    }


}