package christmas.domain;

import christmas.model.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BadgeTest {

    @DisplayName("배지 산타 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(longs = {30000, 25000, 20000, 500000, 40000})
    void valueOf_EqualSanta_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isEqualTo(Badge.산타);
    }

    @DisplayName("배지 트리 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(longs = {10000, 10001, 19999, 15000, 14000})
    void valueOf_EqualTREE_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isEqualTo(Badge.트리);
    }

    @DisplayName("배지 별 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(longs = {5000, 5001, 9999, 7000, 8000})
    void valueOf_EqualSTAR_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isEqualTo(Badge.별);
    }

    @DisplayName("배지 산타 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(longs = {19999, 5000, 10001, 4000, 3000})
    void valueOf_EqualNotSanta_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isNotEqualTo(Badge.산타);
    }

    @DisplayName("배지 트리 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(longs = {30000, 5000, 50000, 1000, 4000})
    void valueOf_EqualNotTREE_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isNotEqualTo(Badge.트리);
    }

    @DisplayName("배지 별 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1000, 30000, 15000, 16000, 2000})
    void valueOf_EqualNotSTAR_Success(long input) {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(input);
        //then
        assertThat(badge).isNotEqualTo(Badge.별);
    }




}
