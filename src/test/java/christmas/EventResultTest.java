package christmas;

import christmas.model.Calculator;
import christmas.model.EventChecker;
import christmas.model.EventResult;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.view.OutputView;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventResultTest {

    @DisplayName("EventResult 정상 생성 테스트")
    @Test
    void EventResultCreateOf_EqualResult_Success() {

        //given
        EventChecker eventChecker = new EventChecker();
        Menus menus = Menu.splitMenuWithNameAndCount("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 3);
        List<Long> events = eventResult.getEventResult();

        //then

    }

    @DisplayName("예상 결제 금액 계산")
    @Test
    void calculateExpectedPaymentAmount_EqualResult_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Calculator calculator = new Calculator();
        Menus menus = Menu.splitMenuWithNameAndCount("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 3);
        int totalAmount = calculator.calculateTotalOrderAmount(menus);
        long expectedPaymentAmount = eventResult.calculateExpectedPaymentAmount(totalAmount);
        System.out.println(expectedPaymentAmount);
        //then
        assertThat(expectedPaymentAmount).isEqualTo(135754);


    }


}