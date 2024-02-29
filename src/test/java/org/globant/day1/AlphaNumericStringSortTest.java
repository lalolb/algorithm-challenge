package org.globant.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AlphaNumericStringSortTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "aKn8!T3%4#(HGdv46==gEE55","%&/UAaé4ü9ú","DH¶F#\\DÁÖldf/","abeCD4®","/56Ul"
    })
    void solve_resultLength_shouldMatchInputLength(String input) {
        // Arrange
        AlphaNumericStringSort alphaNumericStringSort = new AlphaNumericStringSort(input);

        // Act
        var result = alphaNumericStringSort.solve();

        // Assert
        Assertions.assertEquals(input.length(), result.length());
    }

    @ParameterizedTest
    @CsvSource({
            "$63adV53%&Ul/,adlVU3536$%&/",
            "aC$#áÁ@29Ba,aaCB92$#áÁ@",
            "óf35#cgd83Rl,fcgdlR3538ó#"
    })
    void solve_shouldOrderCharacterAsExpected(String input, String expected) {
        // Arrange
        AlphaNumericStringSort alphaNumericStringSort = new AlphaNumericStringSort(input);

        // Act
        var result = alphaNumericStringSort.solve();

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
