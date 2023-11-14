package christmas.domain;

import christmas.model.Calculator;
import christmas.model.DiscountInfo;
import christmas.model.EventChecker;
import christmas.model.EventResult;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventResultTest {

    private EventChecker eventChecker;
    private Calculator calculator;
    private Planner planner;
    private Menus menus;


    @BeforeEach
    void setUp() {
        this.eventChecker = new EventChecker();
        this.planner = new Planner();
        this.calculator = new Calculator();
    }

    @DisplayName("EventResult 할인 4개 정상 생성 테스트")
    @Test
    void EventResultCreateOf_EqualFourResult_Success() {

        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        //when
        EventResult eventResult = eventChecker.createEventResult(menus, 3);
        List<DiscountInfo> events = eventResult.getEventResult();
        List<String> discountInfos = events.stream().map(event -> event.getName()).collect(Collectors.toList());
        //then
        assertThat(events.size()).isEqualTo(4);
        assertThat(discountInfos.contains("크리스마스 디데이 할인")).isTrue();
        assertThat(discountInfos.contains("평일 할인")).isTrue();
        assertThat(discountInfos.contains("특별 할인")).isTrue();
        assertThat(discountInfos.contains("증정 이벤트")).isTrue();

    }

    @DisplayName("EventResult 할인 3개 정상 생성 테스트")
    @Test
    void EventResultCreateOf_EqualThreeResult_Success() {

        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        //when
        EventResult eventResult = eventChecker.createEventResult(menus, 4);
        List<DiscountInfo> events = eventResult.getEventResult();
        List<String> discountInfos = events.stream().map(event -> event.getName()).collect(Collectors.toList());
        //then
        assertThat(events.size()).isEqualTo(3);
        assertThat(discountInfos.contains("크리스마스 디데이 할인")).isTrue();
        assertThat(discountInfos.contains("평일 할인")).isTrue();
        assertThat(discountInfos.contains("증정 이벤트")).isTrue();

    }

    @DisplayName("EventResult 할인 없음 정상 생성 테스트")
    @Test
    void EventResultCreateOf_EqualNone_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("제로콜라-1,타파스-1")));
        //when
        EventResult eventResult = eventChecker.createEventResult(menus, 4);
        List<DiscountInfo> events = eventResult.getEventResult();
        //then
        assertThat(events.size()).isEqualTo(0);
    }


    @DisplayName("예상 결제 금액 계산")
    @Test
    void calculateExpectedPaymentAmount_EqualResult_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        //when
        EventResult eventResult = eventChecker.createEventResult(menus, 3);
        long totalAmount = calculator.calculateTotalOrderAmount(menus);
        long expectedPaymentAmount = eventResult.calculateExpectedPaymentAmount(totalAmount);
        //then
        assertThat(expectedPaymentAmount).isEqualTo(135754);

    }


}
