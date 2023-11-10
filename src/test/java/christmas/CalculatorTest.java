package christmas;

import christmas.model.Calculator;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Product;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("총 주문 금액 계산 성공 테스트")
    @Test
    void calculateTotalOrderAmount_EqualResult_Success() {
        Calculator calculator = new Calculator();

        Menus menus = new Menus(List.of(Menu.초코케이크, Menu.바비큐립, Menu.샴페인));

        int totalOrderAmount = calculator.calculateTotalOrderAmount(menus);

        assertThat(totalOrderAmount).isEqualTo(15000 + 54000 + 25000);
    }

    @DisplayName("총 주문 금액 계산 실패 테스트")
    @Test
    void calculateTotalOrderAmount_DifferentResult_Fail() {
        Calculator calculator = new Calculator();

        Menus menus = new Menus(List.of(Menu.초코케이크, Menu.바비큐립, Menu.샴페인));

        int totalOrderAmount = calculator.calculateTotalOrderAmount(menus);

        assertThat(totalOrderAmount).isNotEqualTo(15000 + 54000 + 30000);
    }


}
