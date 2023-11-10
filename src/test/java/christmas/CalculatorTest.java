package christmas;

import christmas.model.Calculator;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.model.Product;
import christmas.view.OutputView;
import java.sql.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("총 주문 금액 계산 성공 테스트")
    @Test
    void calculateTotalOrderAmount_EqualResult_Success() {
        //given
        Calculator calculator = new Calculator();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-1,바비큐립-1,샴페인-1");
        //when
        int totalOrderAmount = calculator.calculateTotalOrderAmount(menus);
        //then
        assertThat(totalOrderAmount).isEqualTo(15000 + 54000 + 25000);
        OutputView.printMenus(menus.getMenus());
    }

    @DisplayName("총 주문 금액 계산 실패 테스트")
    @Test
    void calculateTotalOrderAmount_DifferentResult_Fail() {
        //given
        Calculator calculator = new Calculator();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-5,바비큐립-1,샴페인-1");
        //when
        int totalOrderAmount = calculator.calculateTotalOrderAmount(menus);
        //then
        assertThat(totalOrderAmount).isNotEqualTo(15000 + 54000 + 30000);
        OutputView.printMenus(menus.getMenus());

    }


    @DisplayName("총 혜택 금액 계산 성공 테스트")
    @Test
    void calculateTotalBenefitAmount_EqualResult_Success() {
        //given
        Calculator calculator = new Calculator();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-5,바비큐립-1,샴페인-1");

        //when
        calculator.calculateTotalBenefitAmount(menus);

        //then

    }


}
