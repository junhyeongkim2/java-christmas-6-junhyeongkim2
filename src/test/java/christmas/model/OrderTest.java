package christmas.model;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    @DisplayName("할인 전 총주문 금액 메인 + 음료 계산 테스트")
    @Test
    void calculateTotalOrder_MainAndDrinkEqualAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        Order order = new Order(menus);
        //when
        int totalOrderAmount = order.calculateTotalOrderAmount();
        //then
        assertThat(totalOrderAmount).isEqualTo(Menu.레드와인.getPrice()*3 + Menu.바비큐립.getPrice()*5);
    }


    @DisplayName("할인 전 총주문 금액 메인 + 디저트 계산 테스트")
    @Test
    void calculateTotalOrder_MainAndDessertEqualAmount_Success() {
        //given
        Map<Menu, Integer> menus = new EnumMap<>(Menu.class);
        menus.put(Menu.아이스크림, 3);
        menus.put(Menu.바비큐립, 5);
        Order order = new Order(menus);
        //when
        int totalOrderAmount = order.calculateTotalOrderAmount();
        //then
        assertThat(totalOrderAmount).isEqualTo(Menu.아이스크림.getPrice()*3 + Menu.바비큐립.getPrice()*5);
    }



}
