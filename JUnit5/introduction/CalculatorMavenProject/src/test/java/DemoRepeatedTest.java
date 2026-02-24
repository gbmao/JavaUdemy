import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    private Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {

        System.out.println("Executing @BeforeEach method");

        calculator = new Calculator();
    }

    @DisplayName("Divided By Zero")
    @RepeatedTest(value=3, name="{displayName}, Repetition {currentRepetition} of " +
            "{totalRepetitions}")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {



        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());

        // Arrange
        int dividend =4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act && Assert

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend,divisor);
        });

        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }
}
