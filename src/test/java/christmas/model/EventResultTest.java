package christmas.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class EventResultTest {

    @DisplayName("이벤트 결과 생성 테스트")
    @Test
    void createResult_EqualResult_Success() {
        //given
        EventResult eventResult = new EventResult(List.of(new EventType("event1"), new EventType("event2")));
        //when
        List<EventType> events = eventResult.getEvents();
        //then
        assertThat(events.size()).isEqualTo(2);
        assertThat(events.get(0).name()).isEqualTo("event1");
        assertThat(events.get(1).name()).isEqualTo("event2");

    }


}
