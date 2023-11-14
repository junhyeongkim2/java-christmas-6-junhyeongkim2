package christmas.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;

public class InputViewTest {


    @BeforeEach
    void consoleClose() {
        Console.close();
    }

    @DisplayName("방문할 날짜가 범위를 초과한 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-5", "32", "100", "5000"})
    void validateInRange_IsNotInRnage_ExceptionThrow(String input) {

        assertThatThrownBy(() -> InputView.validateInRange(input)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("방문할 날짜가 숫자가 아닌 값이 들어왔을 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "c", "d", "e"})
    void validateIsInteger_IsNotInteger_ExceptionThrow(String input) {
        assertThatThrownBy(() -> InputView.validateIsInteger(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("음료만 주문 시 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-5,레드와인-3", "제로콜라-5", "레드와인-5", "샴페인-2", "제로콜라-5,레드와인-5,샴페인-2", "샴페인-2,제로콜라-1"})
    void validateIsOnlyDrinkMenu_IsOnlyDrink_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴 한번에 최대 20개가 넘을 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-5,타파스-15,티본스테이크-1", "제로콜라-21,타파스-5", "티본스테이크-20,아이스크림-5", "시저샐러드-5,양송이수프-50",
            "해산물파스타-1000"})
    void validateIsOverTwentyMenu_IsOverTwenty_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 없는 메뉴가 입력될 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"없는메뉴입니다-1,타파스-5", "티본스테이크-5,이상한메뉴-5", "제로콜라-5,환타-5,티본스테이크-5"})
    void validateIsContainMenu_IsContain_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 1 이상의 숫자가 아닌 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-0,티본스테이크-5,제로콜라-1", "제로콜라-1,티본스테이크-6,샴페인-0", "해산물파스타-1,타파스-0"})
    void validateIsOverOneMenu_IsUnderOne_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 숫자가 아닌 값이 입력될 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-aaa,티본스테이크-5,제로콜라-1", "제로콜라-1,티본스테이크-6,샴페인-bbb", "해산물파스타-1,타파스-wer"})
    void validateIsIntegerMenuCount_IsNotInteger_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 형식이 예시와 다른 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"타파스&3,티본스테이크-5,제로콜라*1", "())제로콜라1,())티본스테이크-6!@샴페인@3", "해산물파스타-1,(타파스-4"})
    void validateMenuForm_IsDifferent_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴 중복 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,타파스-1", "티본스테이크-1,제로콜라-1,티본스테이크-1", "제로콜라-1,제로콜라-1,타파스-1"})
    void validateMenuForm_IsDuplicatedMenu_ExceptionThrow(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(
                IllegalArgumentException.class);
    }


}
