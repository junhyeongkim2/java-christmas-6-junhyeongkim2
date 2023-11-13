package christmas.domain;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import christmas.view.InputView;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenusTest {

    Menus menus;

    @BeforeEach
    void setUp() {
        menus = Menus.from(InputView.splitMenuAndCount(InputView.splitMenuWithComma("타파스-1,초코케이크-1,제로콜라-2,티본스테이크-1")));
    }

    @DisplayName("Menus 정적 팩터리 메서드 map 생성 메뉴 확인 테스트")
    @Test
    void from_EqualMapSizeAndMenu_Success() {
        //given
        //when
        //then
        assertThat(menus.getMenus().size()).isEqualTo(12);
        assertThat(menus.getMenus().get(Menu.타파스)).isEqualTo(5500);
        assertThat(menus.getMenus().get(Menu.초코케이크)).isEqualTo(15000);
        assertThat(menus.getMenus().get(Menu.제로콜라)).isEqualTo(6000);
        assertThat(menus.getMenus().get(Menu.티본스테이크)).isEqualTo(55000);
    }

    @DisplayName("Menus 총주문금액 계산 테스트")
    @Test
    void totalOrderAmount_EqualAmount_Success() {
        //given
        //when
        //then
        assertThat(menus.totalOrderAmount()).isEqualTo(81500);
    }

    @DisplayName("Menus 총이벤트갯수 계산 테스트")
    @Test
    void totalEventMatchAmount_EqualCount_Success() {
        //given
        //when
        //then
        assertThat(menus.totalEventMatchAmount("에피타이저")).isEqualTo(1);
        assertThat(menus.totalEventMatchAmount("메인")).isEqualTo(1);
        assertThat(menus.totalEventMatchAmount("디저트")).isEqualTo(1);
        assertThat(menus.totalEventMatchAmount("음료")).isEqualTo(2);
    }


}
