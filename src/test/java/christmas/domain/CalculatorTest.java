package christmas.domain;

import christmas.model.Calculator;
import christmas.model.EventChecker;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator;
    private Planner planner;
    private Menus menus;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        this.planner = new Planner();
    }

    @DisplayName("총 주문 금액 계산 성공 테스트")
    @Test
    void calculateTotalOrderAmount_EqualResult_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-1,바비큐립-1,샴페인-1")));
        //when
        long totalOrderAmount = calculator.calculateTotalOrderAmount(menus);
        //then
        assertThat(totalOrderAmount).isEqualTo(15000 + 54000 + 25000);
        OutputView.printMenus(menus.getMenus());
    }

    @DisplayName("총 주문 금액 계산 실패 테스트")
    @Test
    void calculateTotalOrderAmount_DifferentResult_Fail() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,바비큐립-1,샴페인-1")));
        //when
        long totalOrderAmount = calculator.calculateTotalOrderAmount(menus);
        //then
        assertThat(totalOrderAmount).isNotEqualTo(15000 + 54000 + 30000);
        OutputView.printMenus(menus.getMenus());

    }


    @DisplayName("총 혜택 금액 계산 평일 성공 테스트")
    @Test
    void calculateTotalBenefitAmount_WeekdayEqualResult_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        long result = 0;
        //when
        calculator.calculateEventResult(menus, 3);
        result = calculator.calculateTotalBenefitAmount();

        //then
        assertThat(result).isEqualTo(-31246);

    }


    @DisplayName("총 혜택 금액 계산 주말 성공 테스트")
    @Test
    void calculateTotalBenefitAmount_WeekendEqualResult_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        long result = 0;
        //when
        calculator.calculateEventResult(menus, 3);
        result = calculator.calculateTotalBenefitAmount();

        //then
        assertThat(result).isEqualTo(-31246);

    }

    @DisplayName("할인 후 예상 결제 금액 계산 평일 성공 테스트")
    @Test
    void calculateExpectedPaymentAmount_EqualResultWeekDay_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        long result = 0;
        //when
        calculator.calculateTotalOrderAmount(menus);
        calculator.calculateEventResult(menus, 3);
        result = calculator.calculateExpectedPaymentAmount(calculator.calculateTotalOrderAmount(menus));
        //then
        assertThat(result).isEqualTo(142000 + (-31246 + 25000));
    }

    @DisplayName("할인 후 예상 결제 금액 계산 주말 성공 테스트")
    @Test
    void calculateExpectedPaymentAmount_EqualResultWeekEnd_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
        long result = 0;
        //when
        calculator.calculateTotalOrderAmount(menus);
        calculator.calculateEventResult(menus, 8);
        result = calculator.calculateExpectedPaymentAmount(calculator.calculateTotalOrderAmount(menus));
        //then
        assertThat(result).isEqualTo(136254);
    }


}
