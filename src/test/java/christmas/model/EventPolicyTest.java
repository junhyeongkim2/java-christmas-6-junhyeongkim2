package christmas.model;

import christmas.model.Event.ChristmasDdayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EventPolicyTest {

    @DisplayName("크리스마스 이벤트 할인 테스트")
    @Test
    void discount_EqualDiscountAmount_Success() {
        //given
        EventPolicy christmasDdayEvent = new ChristmasDdayEvent();
        //when
        int discountAmount = christmasDdayEvent.discount(25, "menus");
        //then
        assertThat(discountAmount).isEqualTo(3400);

    }


}
