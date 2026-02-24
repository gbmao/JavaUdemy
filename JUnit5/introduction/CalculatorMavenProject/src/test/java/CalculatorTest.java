import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test Math Operation in Calculator class")
class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachTestMethod() {

        System.out.println("Executing @BeforeEach method");

        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @afterEach method.");
    }


    //test<System Under Test>_< Condition or State Change>_<Expected Result>
    @DisplayName("Test 4/2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("4 /2 method.");
        //Arrange //Given

        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        //ACT //When
        int result = calculator.integerDivision(dividend, divisor);

        //Assert // Then
        assertEquals(expectedResult, result, "4/2 did not produce 2");

    }

//    @Disabled(" need work on it")
    @DisplayName("Divided By Zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {

        System.out.println("divided by ZERO method.");

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

    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
//    @MethodSource("integerSubtractionInputParameters")
//    @CsvSource({"33, 1, 32",
//            "24, 1, 23",
//            "54, 1, 53"
//    })
    @CsvFileSource(resources = "/integerSubstraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {

        System.out.println("Running test: " + minuend + "-" + subtrahend + "=" + expectedResult);

        int result = calculator.integerSubtraction(minuend, subtrahend);

        assertEquals(expectedResult, result,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }

//    private static Stream<Arguments> integerSubtractionInputParameters() {
//        return Stream.of(
//                Arguments.of(33,1,32),
//                Arguments.of(24,1,23),
//                Arguments.of(10,15,-5)
//        );
//    }

    @Test
    void testSquareRoot_WhenCallingZero_ShouldThrowIllegalArgumentException(){

        // Arrange
        int number = 0;

        // Act

        String expectedResult = "Cannot calculate square root of negative number";

        IllegalArgumentException actualResult = assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(number);
        });

        // Assertion

        assertEquals(expectedResult, actualResult.getMessage());
    }

    @Test
    void testSquareRoot_WhenCallingNegativeNumber_ShouldThrowIllegalArgumentException() {

        // Arrange

        int number = -5;
        String expectedResult = "Cannot calculate square root of negative number";

        // Act

        IllegalArgumentException actualResult = assertThrows(IllegalArgumentException.class,
                () -> {
            calculator.squareRoot(number);
                });


        // Assert

        assertEquals(expectedResult,actualResult.getMessage());
    }
}