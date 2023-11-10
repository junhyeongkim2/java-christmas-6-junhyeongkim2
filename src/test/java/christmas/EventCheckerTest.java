package christmas;

import christmas.model.EventChecker;
import christmas.model.Menu.Menu;
import christmas.model.Menu.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventCheckerTest {

    @DisplayName("증정 이벤트 당첨 성공 테스트")
    @Test
    void checkGiveAwayMenu_IsUpper120000_True() {
        //given
        EventChecker eventChecker = new EventChecker();
        //when
        Boolean checkFlag = eventChecker.checkGiveawayMenu(125000);
        //then
        assertThat(checkFlag).isTrue();
    }

    @DisplayName("증정 이벤트 당첨 실패 테스트")
    @Test
    void checkGiveAwayMenu_IsUnder120000_False() {
        //given
        EventChecker eventChecker = new EventChecker();
        //when
        Boolean checkFlag = eventChecker.checkGiveawayMenu(5000);
        //then
        assertThat(checkFlag).isFalse();
    }


    @DisplayName("평일 할인 조사 성공 테스트")
    @Test
    void checkWeekdayDiscount_IsWeekday_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");

        //when
        long count = eventChecker.checkWeekdayDiscount(menus, 6);

        //then
        assertThat(count).isNotNull();
        assertThat(count).isEqualTo(7);

    }

    @DisplayName("평일 할인 조사 실패 테스트")
    @Test
    void checkWeekdayDiscount_IsNotWeekday_ReturnZero() {
        //given
        EventChecker eventChecker = new EventChecker();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");

        //when
        long count = eventChecker.checkWeekdayDiscount(menus, 30);

        //then
        assertThat(count).isEqualTo(0);
    }

    @DisplayName("주말 할인 조사 성공 테스트")
    @Test
    void checkWeekendDiscount_IsWeekend_Success() {
        //given
        EventChecker eventChecker = new EventChecker();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-1,아이스크림-1,티본스테이크-5,제로콜라-1");

        //when
        long count = eventChecker.checkWeekendDiscount(menus, 8);

        //then
        assertThat(count).isNotNull();
        assertThat(count).isEqualTo(5);

    }

    @DisplayName("주말 할인 조사 실패 테스트")
    @Test
    void checkWeekendDiscount_IsNotWeekend_ReturnZero() {
        //given
        EventChecker eventChecker = new EventChecker();
        Menus menus = Menu.splitMenuWithNameAndCount("초코케이크-1,아이스크림-1,티본스테이크-5,제로콜라-1");

        //when
        long count = eventChecker.checkWeekendDiscount(menus, 28);

        //then
        assertThat(count).isEqualTo(0);

    }


    @DisplayName("특별 할인 조사 성공 테스트")
    @Test
    void checkSpecialDiscount_IsSpecialay_Success() {
        EventChecker eventChecker = new EventChecker();
        Boolean specialFlag = eventChecker.checkSpecialDiscount(31);
        assertThat(specialFlag).isTrue();
    }

    @DisplayName("특별 할인 조사 실패 테스트")
    @Test
    void checkSpecialDiscount_IsNotSpecialay_ReturnFalse() {
        EventChecker eventChecker = new EventChecker();
        Boolean specialFlag = eventChecker.checkSpecialDiscount(13);
        assertThat(specialFlag).isFalse();
    }


}
