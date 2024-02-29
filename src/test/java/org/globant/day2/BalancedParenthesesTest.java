package org.globant.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BalancedParenthesesTest {

    @ParameterizedTest
    @MethodSource("provideInputStrings")
    void test(String input, boolean expected) {
        // Arrange
        BalancedParentheses bp = new BalancedParentheses(input);

        // Act
        boolean result = bp.solve();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideInputStrings() {
        return Stream.of(
                Arguments.of("()",true),
                Arguments.of("(hello, world)",true),
                Arguments.of("Random text (as this) is ok().",true),
                Arguments.of(")(",false),
                Arguments.of("(Hello (,) world (!))",true),
                Arguments.of(")()(",false),
                Arguments.of("())(()",false),
                Arguments.of("(()()((())()))",true),
                Arguments.of("(())((())()",false)
        );
    }
}
