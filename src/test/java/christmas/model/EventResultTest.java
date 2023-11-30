package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventResultTest {

    @DisplayName("이벤트 결과 생성 테스트")
    @Test
    void createResult_EqualResult_Success() {

        EventResult eventResult = new EventResult();
        List<Event> eventResults = eventResult.getEventResult();


    }


}
