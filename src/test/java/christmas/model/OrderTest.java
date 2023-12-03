package christmas.model;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    @DisplayName("할인 전 총주문 금액 메인 + 음료 계산 테스트")
    @Test
    void calculateTotalOrder_MainAndDrinkEqualAmount_Success() {
        //given
        Order order = Order.of("레드와인-3,바비큐립-5");
        //when
        int totalOrderAmount = order.calculateTotalOrderAmount();
        //then
        assertThat(totalOrderAmount).isEqualTo(Menu.레드와인.getPrice() * 3 + Menu.바비큐립.getPrice() * 5);
    }


    @DisplayName("할인 전 총주문 금액 메인 + 디저트 계산 테스트")
    @Test
    void calculateTotalOrder_MainAndDessertEqualAmount_Success() {
        //given
        Order order = Order.of("아이스크림-3,바비큐립-5");
        //when
        int totalOrderAmount = order.calculateTotalOrderAmount();
        //then
        assertThat(totalOrderAmount).isEqualTo(Menu.아이스크림.getPrice() * 3 + Menu.바비큐립.getPrice() * 5);
    }

    @DisplayName("음료만 주문 시 에러 발생 테스트")
    @Test
    void validateIsOnlyDrink_IfOnlyDrink_ExceptionThrow() {
        //given&&when&&then
        assertThatThrownBy(() -> Order.of("샴페인-5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 한 번에 최대 20개 넘을 경우 에러 발생 테스트")
    @Test
    void validateIsOverTwentyMenu_IfOverTwentyMenu_ExceptionThrow() {
        //given&&when&&then
        assertThatThrownBy(() -> Order.of("샴페인-5,타파스-16")).isInstanceOf(IllegalArgumentException.class);
    }


}
