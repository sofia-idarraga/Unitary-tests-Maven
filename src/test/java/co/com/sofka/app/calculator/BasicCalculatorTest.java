package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing subtraction: 6-1=5")
    public void subtract() {
        // Arrange
        Long number1 = 6L;
        Long number2 = 1L;
        Long expectedValue = 5L;

        // Act
        Long result = basicCalculator.subtract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing multiply: 10*2=20")
    public void multiply() {
        // Arrange
        Long number1 = 10L;
        Long number2 = 2L;
        Long expectedValue = 20L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing division: 10/2=5")
    public void division() {
        // Arrange
        Long number1 = 10L;
        Long number2 = 2L;
        Long expectedValue = 5L;

        // Act
        Long result = basicCalculator.division(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing division: 10/0= IllegalArgumentException")
    public void divisionByZero() {
        // Arrange
        Long number1 = 10L;
        Long number2 = 0L;

        // Assert
        assertThrows(IllegalArgumentException.class, ()-> {
            //Act
            basicCalculator.division(number1, number2);

        });
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subtractions")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "4,    2,   2",
            "70,  21, 49",
            "1029,  123, 906"
    })
    public void severalSubtract(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "3,    4,   12",
            "70,  21, 1470",
            "1029,  123, 126567"
    })
    public void severalMultiplication(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "4,    2,   2",
            "126,  6, 21",
            "1053,  3, 351"
    })
    public void severalDivision(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.division(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }
}
