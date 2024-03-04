package org.globant.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PascalTriangleTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,5,6,10,20})
    void test_pascalTriangle(int numberOfRows) {
        // Arrange
        PascalTriangle pascalTriangle = new PascalTriangle();

        // Act
        var triangle = pascalTriangle.generate(numberOfRows);

        // Assert
        Assertions.assertAll(() -> {
                Assertions.assertEquals(numberOfRows, triangle.length);
                Assertions.assertEquals(numberOfRows, triangle[numberOfRows-1].length);
        });
    }
}
