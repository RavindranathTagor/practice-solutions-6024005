package com.cognizant.fse.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Simple AAA Pattern Examples")
class SimpleAAAPatternDemo {

    private Calculator calculator;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Fresh calculator instance created");
    }

    /**
     * Teardown method - equivalent to @After in JUnit 4
     * Runs after each test to clean up resources
     */
    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance cleaned up");
    }

    @Test
    @DisplayName("Simple AAA: Testing Addition")
    void testSimpleAddition() {
        // ===== ARRANGE =====
        // Set up the test data and expected results
        int number1 = 5;
        int number2 = 3;
        int expectedSum = 8;

        // ===== ACT =====
        // Execute the method we're testing
        int actualSum = calculator.add(number1, number2);

        // ===== ASSERT =====
        // Verify the result matches our expectations
        assertEquals(expectedSum, actualSum, "5 + 3 should equal 8");
    }

    @Test
    @DisplayName("Simple AAA: Testing Subtraction")
    void testSimpleSubtraction() {
        // ===== ARRANGE =====
        int minuend = 10;
        int subtrahend = 4;
        int expectedDifference = 6;

        // ===== ACT =====
        int actualDifference = calculator.subtract(minuend, subtrahend);

        // ===== ASSERT =====
        assertEquals(expectedDifference, actualDifference, "10 - 4 should equal 6");
    }

    @Test
    @DisplayName("Simple AAA: Testing Multiplication")
    void testSimpleMultiplication() {
        // ===== ARRANGE =====
        int factor1 = 7;
        int factor2 = 6;
        int expectedProduct = 42;

        // ===== ACT =====
        int actualProduct = calculator.multiply(factor1, factor2);

        // ===== ASSERT =====
        assertEquals(expectedProduct, actualProduct, "7 * 6 should equal 42");
    }

    @Test
    @DisplayName("Simple AAA: Testing Division")
    void testSimpleDivision() {
        // ===== ARRANGE =====
        int dividend = 15;
        int divisor = 3;
        double expectedQuotient = 5.0;

        // ===== ACT =====
        double actualQuotient = calculator.divide(dividend, divisor);

        // ===== ASSERT =====
        assertEquals(expectedQuotient, actualQuotient, 0.001, "15 / 3 should equal 5.0");
    }

    @Test
    @DisplayName("Simple AAA: Testing Exception")
    void testDivisionByZeroException() {
        // ===== ARRANGE =====
        int dividend = 10;
        int invalidDivisor = 0;

        // ===== ACT & ASSERT =====
        // For exception testing, ACT and ASSERT are combined
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.divide(dividend, invalidDivisor),
            "Division by zero should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Simple AAA: Testing Boolean Method")
    void testEvenNumberCheck() {
        // ===== ARRANGE =====
        int evenNumber = 8;
        int oddNumber = 7;

        // ===== ACT =====
        boolean evenResult = calculator.isEven(evenNumber);
        boolean oddResult = calculator.isEven(oddNumber);

        // ===== ASSERT =====
        assertTrue(evenResult, "8 should be even");
        assertFalse(oddResult, "7 should be odd");
    }


    @Test
    @DisplayName("Simple AAA: Complex Calculation Chain")
    void testCalculationChain() {
        // ===== ARRANGE =====
        // Set up multiple test values for a complex calculation
        int a = 5;
        int b = 3;
        int c = 2;
        // Expected: (a + b) * c = (5 + 3) * 2 = 8 * 2 = 16
        int expectedFinalResult = 16;

        // ===== ACT =====
        // Perform the calculation in steps
        int step1Result = calculator.add(a, b);        // 5 + 3 = 8
        int finalResult = calculator.multiply(step1Result, c); // 8 * 2 = 16

        // ===== ASSERT =====
        // Verify both intermediate and final results
        assertEquals(8, step1Result, "First step should equal 8");
        assertEquals(expectedFinalResult, finalResult, "Final result should equal 16");
    }
}


