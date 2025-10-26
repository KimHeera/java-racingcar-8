package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동자_한_대_경주() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "5");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Given
    private Car car = new Car("pobi"); // 초기 position은 0

    @Test
    @DisplayName("무작위_값_3_이하일_경우_자동차가_멈춘다")
    void should_not_move_when_random_value_is_three() {
        // When: 3 이하의 값으로 move()를 호출
        car.move(3);

        // Then: position이 0으로 유지되는지 검증
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("무작위_값_4_이상일_경우_자동차가_전진한다")
    void should_move_when_random_value_is_four() {
        // When: 4 이상의 값으로 move()를 호출
        car.move(4);

        // Then: position이 1로 증가했는지 검증
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위_값_9일_경우_자동차가_전진한다")
    void should_move_when_random_value_is_nine() {
        // When: 최대값인 9로 move()를 호출
        car.move(9);

        // Then: position이 1로 증가했는지 검증
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
