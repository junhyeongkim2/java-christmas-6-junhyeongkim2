package christmas.view;

import christmas.model.Menu.Menus;
import christmas.model.Planner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OutputViewTest {

    private Planner planner;
    private Menus menus;

    ByteArrayOutputStream captureOutputValues() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }

    @BeforeEach
    void setUp() {
        planner = new Planner();
    }

    @DisplayName("크리스마스 시작 출력 메세지 테스트")
    @Test
    void printStartChristmasPlannerMessageTest_EqaulMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        OutputView.printStartChristmasPlannerMessage();
        //then
        assertThat(output.toString()).isEqualTo("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n");
    }

    @DisplayName("할인 혜택 시작 출력 메세지 테스트")
    @Test
    void printStartBenefitMessage_EqaulMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        OutputView.printStartBenefitMessage(26);
        //then
        assertThat(output.toString()).isEqualTo("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n");
    }

    @DisplayName("Menus Map 출력 메세지 테스트")
    @Test
    void printMenus_EqualMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        OutputView.printMenus(menus.getMenus());
        //then
        assertThat(output.toString()).isEqualTo("<주문 메뉴>\n타파스 1개\n티본스테이크 1개\n\n");
    }

    @DisplayName("할인 전 총주문 금액 출력 메세지 테스트")
    @Test
    void printTotalOrderAmount_EqualMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        long totalOrderAmount = planner.requestTotalOrderAmount(menus);
        //then
        OutputView.printTotalOrderAmount(totalOrderAmount);
        assertThat(output.toString()).isEqualTo("<할인 전 총주문 금액>\n60,500원\n\n");
    }

    @DisplayName("증정 메뉴 없음 출력 메세지 테스트")
    @Test
    void printGiveawayMenu_EqualNothingMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        OutputView.printGiveawayMenu(planner.requestGiveawayMenuResult(menus, 6));
        //then
        assertThat(output.toString()).isEqualTo("<증정 메뉴>\n없음\n\n");
    }

    @DisplayName("증정 메뉴 샴페인 출력 메세지 테스트")
    @Test
    void printGiveawayMenu_EqualChampagneMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-5")));
        OutputView.printGiveawayMenu(planner.requestGiveawayMenuResult(menus, 6));
        //then
        assertThat(output.toString()).isEqualTo("<증정 메뉴>\n샴페인 1개\n\n");
    }

    @DisplayName("총혜택 금액 출력 메세지 테스트")
    @Test
    void printTotalBenefitAmount_EqualMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        planner.requestEventResult(menus, 6);
        OutputView.printTotalBenefitAmount(planner.requestTotalBenefitAmount());
        //then
        assertThat(output.toString()).isEqualTo("<총혜택 금액>\n-1,500원\n\n");
    }

    @DisplayName("총혜택 금액 Zero 출력 메세지 테스트")
    @Test
    void printTotalBenefitAmount_EqualNothingMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        planner.requestEventResult(menus, 27);
        OutputView.printTotalBenefitAmount(planner.requestTotalBenefitAmount());
        //then
        assertThat(output.toString()).isEqualTo("<총혜택 금액>\n0원\n\n");
    }

    @DisplayName("할인 후 예상 결제 금액 출력 메세지 테스트")
    @Test
    void printExpectedPaymentAmount_EqualMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        planner.requestEventResult(menus, 6);
        OutputView.printExpectedPaymentAmount(
                planner.requestExpectedPaymentAmount(planner.requestTotalOrderAmount(menus)));
        //then
        assertThat(output.toString()).isEqualTo("<할인 후 예상 결제 금액>\n59,000원\n\n");
    }

    @DisplayName("12월 이벤트 배지 산타 출력 메세지 테스트")
    @Test
    void printBadge_EqualSantaMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-10")));
        planner.requestTotalOrderAmount(menus);
        planner.requestEventResult(menus, 8);
        planner.requestTotalBenefitAmount();
        OutputView.printBadge(planner.requestBadge());
        //then
        assertThat(output.toString()).isEqualTo("<12월 이벤트 배지>\n산타\n");
    }

    @DisplayName("12월 이벤트 배지 별 출력 메세지 테스트")
    @Test
    void printBadge_EqualStarMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-2")));
        planner.requestEventResult(menus, 8);
        planner.requestTotalBenefitAmount();
        OutputView.printBadge(planner.requestBadge());
        //then
        assertThat(output.toString()).isEqualTo("<12월 이벤트 배지>\n별\n");
    }

    @DisplayName("12월 이벤트 배지 없음 출력 메세지 테스트")
    @Test
    void printBadge_EqualNothingMessage_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,티본스테이크-1")));
        planner.requestEventResult(menus, 8);
        planner.requestTotalBenefitAmount();
        OutputView.printBadge(planner.requestBadge());
        //then
        assertThat(output.toString()).isEqualTo("<12월 이벤트 배지>\n없음\n");
    }

    @DisplayName("DecimalFormat 변환 기능 테스트")
    @Test
    void replaceToDecimalFormat_EqualFormat_Success() {
        //given
        //when
        String replacedFormat = OutputView.replaceToDecimalFormat(1111111111111111l);
        //then
        assertThat(replacedFormat).isEqualTo("1,111,111,111,111,111");
    }


}
