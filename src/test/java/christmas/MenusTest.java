package christmas;

import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenusTest {


    @DisplayName("입력된 메뉴 분리시 존재하지 않는 메뉴이면 예외 발생")
    @Test
    void splitMenus_IsNotContinasMenu_ExceptionThrow() {

        //given
        String menuInput = "타파스-1,제로콜라-1,이상한메뉴-2";

        //when

        //then
        assertThatThrownBy(() -> Menu.createMenusFrom(menuInput)).isInstanceOf(
                IllegalArgumentException.class);
    }


    @DisplayName("입력된 메뉴 분리시 존재하는 메뉴이면 테스트 성공")
    @Test
    void splitMenus_IsContinasMenu_ExceptionThrow() {

        //given
        String menuInput = "타파스-1,제로콜라-1,티본스테이크-2";

        //when
        Menus menus = Menu.createMenusFrom(menuInput);

        //then
        assertThat(menus.getMenus().size()).isEqualTo(11);
        assertThat(menus.getMenus().get(Menu.타파스)).isEqualTo(5500);
        assertThat(menus.getMenus().get(Menu.제로콜라)).isEqualTo(3000);
        assertThat(menus.getMenus().get(Menu.티본스테이크)).isEqualTo(110000);
    }


}
