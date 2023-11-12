package christmas;

import christmas.model.Badge;
import christmas.model.Calculator;
import christmas.model.Event.DiscountInfo;
import christmas.model.EventChecker;
import christmas.model.EventResult;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
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
        Planner planner = new Planner();
        Menus menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 3);
        List<DiscountInfo> events = eventResult.getEventResult();

        //then

    }

    @DisplayName("예상 결제 금액 계산")
    @Test
    void calculateExpectedPaymentAmount_EqualResult_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Calculator calculator = new Calculator();
        Planner planner = new Planner();
        Menus menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 3);
        long totalAmount = calculator.calculateTotalOrderAmount(menus);
        long expectedPaymentAmount = eventResult.calculateExpectedPaymentAmount(totalAmount);
        System.out.println(expectedPaymentAmount);
        //then
        assertThat(expectedPaymentAmount).isEqualTo(135754);

    }


    @DisplayName("12월 이벤트 배지 산타 생성 테스트")
    @Test
    void generateBadge_EqualSanta_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Calculator calculator = new Calculator();
        Planner planner = new Planner();
        Menus menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));

        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 3);
        long totalAmount = calculator.calculateTotalOrderAmount(menus);
        long totalBenefitAmount = eventResult.calculateTotalBenefit();
        long expectedPaymentAmount = eventResult.calculateExpectedPaymentAmount(totalAmount);
        Badge badge = eventResult.generateBadge();

        System.out.println(badge);
        //then
        assertThat(badge).isEqualTo(Badge.산타);
    }

    @DisplayName("12월 이벤트 배지 별 생성 테스트")
    @Test
    void generateBadge_EqualStar_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Planner planner = new Planner();
        Menus menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-1")));
        //when
        EventResult eventResult = eventChecker.checkEvent(menus, 25);
        long totalBenefitAmount = eventResult.calculateTotalBenefit();

        Badge badge = eventResult.generateBadge();

        System.out.println(badge);
        //then
        assertThat(badge).isEqualTo(Badge.별);
    }


}
