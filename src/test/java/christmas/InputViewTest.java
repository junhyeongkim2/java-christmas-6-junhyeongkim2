package christmas;

import christmas.model.Planner;
import christmas.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertThatThrownBy(() -> InputView.splitMenuAndCount(InputView.splitMenuWithComma(input))).isInstanceOf(IllegalArgumentException.class);
    }


}
