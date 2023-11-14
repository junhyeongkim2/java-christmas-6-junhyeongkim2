package christmas.domain;

import christmas.model.Badge;
import christmas.model.DiscountInfo;
import christmas.model.EventResult;
import christmas.model.Menu.Menus;
import christmas.model.Planner;
import christmas.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PlannerTest {

    Planner planner;
    Menus menus;

    @BeforeEach
    void setUp() {
        planner = new Planner();
        menus = planner.isContainMenu(
                InputView.splitMenuAndCount(InputView.splitMenuWithComma("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")));
    }

    @DisplayName("메뉴 확인 정상 작동 테스트")
    @Test
    void IsContainMenu_EqualTotalOrderAmount_Success() {
        //given

        //when
        long totalOrderAmount = menus.totalOrderAmount();
        //then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }


    @DisplayName("총주문 금액 요청 정상 작동 테스트")
    @Test
    void requestTotalOrderAmount_EqualTotalOrderAmount_Success() {
        //given

        //when
        long totalOrderAmount = planner.requestTotalOrderAmount(menus);

        //then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }

    @DisplayName("증정 메뉴 계산 정상 작동 테스트")
    @Test
    void requestGiveawayMenuResult_EqualPrice_Success() {
        //given
        long result = 0;
        //when
        planner.requestTotalOrderAmount(menus);
        DiscountInfo discountInfo = planner.requestGiveawayMenuResult(menus, 6);
        //then
        assertThat(discountInfo.getDiscount()).isEqualTo(-25000);
    }

    @DisplayName("총혜택 금액 요청 정상 작동 테스트")
    @Test
    void requestTotalBenefitAmount_EqualResult_Success() {
        //given
        EventResult eventResult;
        //when
        eventResult = planner.requestEventResult(menus, 6);
        long totalBenefitAmount = planner.requestTotalBenefitAmount();
        //then
        assertThat(totalBenefitAmount).isEqualTo(-30546);
    }

    @DisplayName("예상 결제 금액 요청 정상 작동 테스트")
    @Test
    void requestExpectedPaymentAmount_EqualResult_Success() {
        //given
        //when
        planner.requestEventResult(menus, 6);
        planner.requestTotalBenefitAmount();
        long expectedPaymentAmount = planner.requestExpectedPaymentAmount(planner.requestTotalOrderAmount(menus));
        //then
        assertThat(expectedPaymentAmount).isEqualTo(136454);
    }


    @DisplayName("뱃지 요청 산타 반환 테스트")
    @Test
    void requestBadge_EqualSanta_Success() {
        //given
        EventResult eventResult;
        //when
        eventResult = planner.requestEventResult(menus, 6);
        planner.requestTotalBenefitAmount();
        Badge badge = planner.requestBadge();

        //then
        assertThat(badge).isEqualTo(Badge.산타);
    }


}
