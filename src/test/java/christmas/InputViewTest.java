package christmas;

import christmas.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
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


}
