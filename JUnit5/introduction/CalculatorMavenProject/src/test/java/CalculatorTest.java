import org.junit.jupiter.api.*;

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

    @DisplayName("Divided By Zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {

        System.out.println("divided by ZERO method.");
        assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(5,0);
        });
    }

    @DisplayName("Test 4 - 1 = 3")
    @Test
    void integerSubtraction() {

        System.out.println("4 -1 = 3 method.");

        int minuend = 4;
        int subtrahend = 1;
        int expectedResult = 3;

        int result = calculator.integerSubtraction(minuend, subtrahend);

        assertEquals(expectedResult, result,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }
}