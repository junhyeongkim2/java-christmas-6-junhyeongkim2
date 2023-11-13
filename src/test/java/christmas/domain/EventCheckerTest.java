package christmas;

import christmas.model.DiscountInfo;
import christmas.model.Event.EventType;
import christmas.model.EventChecker;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventCheckerTest {
    private EventChecker eventChecker;
    private Planner planner;
    private Menus menus;

    @BeforeEach
    void setUp() {
        this.eventChecker = new EventChecker();
        this.planner = new Planner();
    }

    @DisplayName("증정 이벤트 당첨 성공 테스트")
    @Test
    void checkGiveAwayMenu_IsUpper120000_True() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1")));
        //when
        DiscountInfo discountInfo = eventChecker.checkGiveawayMenu(menus, 6);
        //then
        assertThat(discountInfo.getDiscount()).isEqualTo(-25000);
    }

    @DisplayName("증정 이벤트 당첨 실패 테스트")
    @Test
    void checkGiveAwayMenu_IsUnder120000_False() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("아이스크림-2,티본스테이크-1,제로콜라-1")));
        long totalOrderAmount = planner.requestTotalOrderAmount(menus);
        //when
        DiscountInfo discountInfo = eventChecker.checkGiveawayMenu(menus, 6);
        //then
        assertThat(totalOrderAmount).isLessThan(120000);
        assertThat(discountInfo.getName()).isEqualTo(EventType.GIVEAWAY.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(0);
    }


    @DisplayName("평일 할인 조사 성공 테스트")
    @Test
    void checkWeekdayDiscount_IsWeekday_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1")));
        //when
        DiscountInfo discountInfo = eventChecker.checkWeekdayDiscount(menus, 6);

        //then
        assertThat(discountInfo).isNotNull();
        assertThat(discountInfo.getName()).isEqualTo(EventType.WEEKDAY.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(-2023 * 7);

    }

    @DisplayName("평일 할인 조사 실패 테스트")
    @Test
    void checkWeekdayDiscount_IsNotWeekday_ReturnZero() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1")));
        //when
        DiscountInfo discountInfo = eventChecker.checkWeekdayDiscount(menus, 30);

        //then
        assertThat(discountInfo.getName()).isEqualTo(EventType.WEEKDAY.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(0);
    }

    @DisplayName("주말 할인 조사 성공 테스트")
    @Test
    void checkWeekendDiscount_IsWeekend_Success() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1")));
        //when
        DiscountInfo discountInfo = eventChecker.checkWeekendDiscount(menus, 8);

        //then
        assertThat(discountInfo).isNotNull();
        assertThat(discountInfo.getName()).isEqualTo(EventType.WEEKEND.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(-2023);

    }

    @DisplayName("주말 할인 조사 실패 테스트")
    @Test
    void checkWeekendDiscount_IsNotWeekend_ReturnZero() {
        //given
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("초코케이크-5,아이스크림-2,티본스테이크-1,제로콜라-1")));
        //when
        DiscountInfo discountInfo = eventChecker.checkWeekendDiscount(menus, 29);

        //then
        assertThat(discountInfo.getName()).isEqualTo(EventType.WEEKEND.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(-2023);

    }


    @DisplayName("특별 할인 조사 성공 테스트")
    @Test
    void checkSpecialDiscount_IsSpecialay_Success() {
        //given
        DiscountInfo discountInfo;
        //when
        discountInfo = eventChecker.checkSpecialDiscount(menus,31);
        //then
        assertThat(discountInfo.getName()).isEqualTo(EventType.SPECIAL.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(-1000);
    }

    @DisplayName("특별 할인 조사 실패 테스트")
    @Test
    void checkSpecialDiscount_IsNotSpecialay_ReturnFalse() {
        //given
        DiscountInfo discountInfo;
        //when
        discountInfo = eventChecker.checkSpecialDiscount(menus,13);
        //then
        assertThat(discountInfo.getDiscount()).isEqualTo(0);
    }

    @DisplayName("디데이 할인 성공 테스트")
    @Test
    void checkDdayDiscount_EqualResult_Success() {
        //given
        DiscountInfo discountInfo;
        //when
        discountInfo = eventChecker.checkDdayDiscount(menus,25);
        //then
        assertThat(discountInfo.getName()).isEqualTo(EventType.DDAY.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(-3400);
    }


    @DisplayName("디데이 할인 실패 테스트")
    @Test
    void checkDdayDiscount_DiferentResult_Success() {
        //given
        DiscountInfo discountInfo;
        //when
        discountInfo = eventChecker.checkDdayDiscount(menus,28);
        //then
        assertThat(discountInfo.getName()).isEqualTo(EventType.DDAY.getName());
        assertThat(discountInfo.getDiscount()).isEqualTo(0);
    }


}
