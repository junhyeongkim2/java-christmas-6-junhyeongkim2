//package christmas;
//
//import christmas.model.Event.DiscountInfo;
//import christmas.model.Event.EventType;
//import christmas.model.EventChecker;
//import christmas.model.Menu.Menu;
//import christmas.model.Menu.Menus;
//import jdk.jfr.Event;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//public class EventCheckerTest {
//
//    @DisplayName("증정 이벤트 당첨 성공 테스트")
//    @Test
//    void checkGiveAwayMenu_IsUpper120000_True() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus;
//        //when
//        menus = Menu.createMenusFrom("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");
//        EventType eventType = eventChecker.checkGiveawayMenu(menus, 6);
//        //then
//        assertThat(eventType.getDiscount()).isEqualTo(25000);
//    }
//
//    @DisplayName("증정 이벤트 당첨 실패 테스트")
//    @Test
//    void checkGiveAwayMenu_IsUnder120000_False() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus;
//        //when
//        menus = Menu.createMenusFrom("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");
//        EventType eventType = eventChecker.checkGiveawayMenu(menus,6);
//        //then
//        assertThat(eventType.getDiscount()).isEqualTo(0);
//    }
//
//
//    @DisplayName("평일 할인 조사 성공 테스트")
//    @Test
//    void checkWeekdayDiscount_IsWeekday_Success() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus = Menu.createMenusFrom("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");
//
//        //when
//        EventType eventType = eventChecker.checkWeekdayDiscount(menus, 6);
//
//        //then
//        assertThat(eventType).isNotNull();
//        assertThat(eventType).isEqualTo(EventType.WEEKDAY);
//
//    }
//
//    @DisplayName("평일 할인 조사 실패 테스트")
//    @Test
//    void checkWeekdayDiscount_IsNotWeekday_ReturnZero() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus = Menu.createMenusFrom("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1");
//
//        //when
//        EventType eventType = eventChecker.checkWeekdayDiscount(menus, 30);
//
//        //then
//        assertThat(eventType).isEqualTo(EventType.WEEKDAY);
//    }
//
//    @DisplayName("주말 할인 조사 성공 테스트")
//    @Test
//    void checkWeekendDiscount_IsWeekend_Success() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus = Menu.createMenusFrom("초코케이크-1,아이스크림-1,티본스테이크-5,제로콜라-1");
//
//        //when
//        EventType eventType = eventChecker.checkWeekendDiscount(menus, 8);
//
//        //then
//        assertThat(eventType).isNotNull();
//        assertThat(eventType).isEqualTo(EventType.WEEKEND);
//
//    }
//
//    @DisplayName("주말 할인 조사 실패 테스트")
//    @Test
//    void checkWeekendDiscount_IsNotWeekend_ReturnZero() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        Menus menus = Menu.createMenusFrom("초코케이크-1,아이스크림-1,티본스테이크-5,제로콜라-1");
//
//        //when
//        EventType eventType = eventChecker.checkWeekendDiscount(menus, 28);
//
//        //then
//        assertThat(eventType).isEqualTo(EventType.WEEKEND);
//
//    }
//
//
//    @DisplayName("특별 할인 조사 성공 테스트")
//    @Test
//    void checkSpecialDiscount_IsSpecialay_Success() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        //when
//        EventType eventType = eventChecker.checkSpecialDiscount(31);
//        //then
//        assertThat(eventType.getDiscount()).isEqualTo(1000);
//    }
//
//    @DisplayName("특별 할인 조사 실패 테스트")
//    @Test
//    void checkSpecialDiscount_IsNotSpecialay_ReturnFalse() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        //when
//        EventType eventType = eventChecker.checkSpecialDiscount(13);
//        //then
//        assertThat(eventType.getDiscount()).isEqualTo(0);
//    }
//
//    @DisplayName("디데이 할인 성공 테스트")
//    @Test
//    void checkDdayDiscount_EqualResult_Success() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        //when
//        DiscountInfo discountInfo = eventChecker.checkDdayDiscount(25);
//        //then
//        assertThat(disc).isEqualTo(EventType.DDAY);
//    }
//
//
//    @DisplayName("디데이 할인 실패 테스트")
//    @Test
//    void checkDdayDiscount_DiferentResult_Success() {
//        //given
//        EventChecker eventChecker = new EventChecker();
//        //when
//        EventType eventType = eventChecker.checkDdayDiscount(28);
//        //then
//        assertThat(eventType).isEqualTo(EventType.DDAY);
//    }
//
//
//}
