package org.globant.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TicTacToeTest {

    @ParameterizedTest
    @MethodSource("provideMovesArray")
    void test_ticTacToeGame_shouldReturn_expectedOutcome(int[][] moves, String expectedWinner) {
        // Arrange
        TicTacToe ticTacToe = new TicTacToe();

        // Act
        String actualResult = ticTacToe.play(moves);

        // Assert
        Assertions.assertEquals(expectedWinner, actualResult);
    }

    private static Stream<Arguments> provideMovesArray() {
        return Stream.of(
                Arguments.of(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}, "A"),
                Arguments.of(new int[][]{{1,1},{0,0},{1,0},{2,0},{1,2},{2,1}}, "A"),
                Arguments.of(new int[][]{{1,1},{0,0},{1,0},{0,2},{2,2},{0,1}}, "B"),
                Arguments.of(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}, "B"),
                Arguments.of(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}, "Draw"),
                Arguments.of(new int[][]{{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2},{0,0},{1,1}}, "Draw"),
                Arguments.of(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1}}, "Pending"),
                Arguments.of(new int[][]{{1,0},{1,2},{2,1},{0,1}}, "Pending")
        );
    }
}
