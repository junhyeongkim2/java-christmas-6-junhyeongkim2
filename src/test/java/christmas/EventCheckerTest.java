package christmas;

import christmas.model.EventChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventCheckerTest {

    @DisplayName("증정 이벤트 당첨 성공 테스트")
    @Test
    void checkGiveAwayMenu_IsUpper120000_True() {
        //given
        EventChecker eventChecker = new EventChecker();
        //when
        Boolean checkFlag = eventChecker.checkGiveawayMenu(125000);
        //then
        assertThat(checkFlag).isTrue();
    }

    @DisplayName("증정 이벤트 당첨 실패 테스트")
    @Test
    void checkGiveAwayMenu_IsUnder120000_False() {
        //given
        EventChecker eventChecker = new EventChecker();
        //when
        Boolean checkFlag = eventChecker.checkGiveawayMenu(5000);
        //then
        assertThat(checkFlag).isFalse();
    }

}
