package calculator.runTest;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunTest extends NsTest {
    @Test
    void 계산_테스트_1() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 계산_테스트_2() {
        assertSimpleTest(() -> {
            run("1,3:7");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 계산_테스트_3() {
        assertSimpleTest(() -> {
            run("10:12:14:15,16,21:123");
            assertThat(output()).contains("결과 : 211");
        });
    }

    @Test
    void 계산_테스트_4() {
        assertSimpleTest(() -> {
            run("10000000,10000,10000");
            assertThat(output()).contains("결과 : 10020000");
        });
    }

    @Test
    void 구분자_테스트_1() {
        assertSimpleTest(() -> {
            run("//!\\n1!2!3!5:7,13");
            assertThat(output()).contains("결과 : 31");
        });
    }

    @Test
    void 구분자_테스트_2() {
        assertSimpleTest(() -> {
            run("//!@#$%^\\n1!2@3#5$7%13");
            assertThat(output()).contains("결과 : 31");
        });
    }

    @Test
    void 구분자_테스트_3() {
        assertSimpleTest(() -> {
            run("//ㅇㅏㅓㅜabc{?\\n1ㅇ2ㅓ3a5c7?13");
            assertThat(output()).contains("결과 : 31");
        });
    }

    @Test
    void 구분자_테스트_4() {
        assertSimpleTest(() -> {
            run("//-@\\n8386-2789@101");
            assertThat(output()).contains("결과 : 11276");
        });
    }

    @Test
    void 구분자_테스트_5() {
        assertSimpleTest(() -> {
            run("//*****\\n9898*102");
            assertThat(output()).contains("결과 : 10000");
        });
    }

    @Test
    void 예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1@2*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1\\n3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!12!34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!\n1!0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!\n71!!25"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\n114:12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&\n10101#1010"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}