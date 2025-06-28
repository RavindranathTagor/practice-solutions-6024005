package com.cognizant.fse.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 4: Demonstrating Arrange-Act-Assert (AAA) Pattern with Test Fixtures,
 * Setup and Teardown Methods in JUnit 5.
 */
@DisplayName("AAA Pattern and Test Fixtures Demo")
class AAAPatternTest {

    // Test fixtures - shared test data
    private Calculator calculator;
    private List<String> testLog;
    private static int testCounter;

    /**
     * Class-level setup - runs once before all tests
     * Equivalent to @BeforeClass in JUnit 4
     */
    @BeforeAll
    static void setUpClass() {
        testCounter = 0;
        System.out.println("=== Starting AAA Pattern Test Suite ===");
    }

    /**
     * Method-level setup - runs before each test method
     * Equivalent to @Before in JUnit 4
     */
    @BeforeEach
    void setUp() {
        // Arrange: Initialize test fixtures
        calculator = new Calculator();
        testLog = new ArrayList<>();
        testCounter++;
        
        // Log test initialization
        String testName = "Test #" + testCounter;
        testLog.add("Initialized: " + testName);
        System.out.println("Setting up: " + testName);
    }

    /**
     * Method-level teardown - runs after each test method
     * Equivalent to @After in JUnit 4
     */
    @AfterEach
    void tearDown() {
        // Clean up after each test
        testLog.add("Test completed");
        System.out.println("Tearing down test. Log entries: " + testLog.size());
        
        // Verify cleanup
        assertNotNull(calculator, "Calculator should exist during teardown");
        assertFalse(testLog.isEmpty(), "Test log should have entries");
        
        // Reset fixtures
        calculator = null;
        testLog = null;
    }

    /**
     * Class-level teardown - runs once after all tests
     * Equivalent to @AfterClass in JUnit 4
     */
    @AfterAll
    static void tearDownClass() {
        System.out.println("=== Completed " + testCounter + " tests ===");
        testCounter = 0;
    }

    @Test
    @DisplayName("AAA Pattern: Addition Test")
    void testAdditionUsingAAAPattern() {
        // ARRANGE: Set up test data and expected results
        int firstNumber = 15;
        int secondNumber = 25;
        int expectedSum = 40;
        testLog.add("Arranged: " + firstNumber + " + " + secondNumber);

        // ACT: Execute the method under test
        int actualSum = calculator.add(firstNumber, secondNumber);
        testLog.add("Acted: calculator.add() executed");

        // ASSERT: Verify the result
        assertEquals(expectedSum, actualSum, 
            "Addition of " + firstNumber + " and " + secondNumber + " should equal " + expectedSum);
        testLog.add("Asserted: Result verified");
    }

    @Test
    @DisplayName("AAA Pattern: Subtraction with Negative Result")
    void testSubtractionWithNegativeResult() {
        // ARRANGE: Prepare test scenario where result will be negative
        int minuend = 10;
        int subtrahend = 20;
        int expectedDifference = -10;
        testLog.add("Arranged: " + minuend + " - " + subtrahend);

        // ACT: Perform the subtraction
        int actualDifference = calculator.subtract(minuend, subtrahend);
        testLog.add("Acted: calculator.subtract() executed");

        // ASSERT: Confirm the negative result is correct
        assertEquals(expectedDifference, actualDifference,
            "Subtracting " + subtrahend + " from " + minuend + " should equal " + expectedDifference);
        assertTrue(actualDifference < 0, "Result should be negative");
        testLog.add("Asserted: Negative result verified");
    }

    @Test
    @DisplayName("AAA Pattern: Multiplication by Zero")
    void testMultiplicationByZero() {
        // ARRANGE: Set up multiplication by zero scenario
        int nonZeroNumber = 42;
        int zero = 0;
        int expectedProduct = 0;
        testLog.add("Arranged: " + nonZeroNumber + " * " + zero);

        // ACT: Execute multiplication
        int actualProduct = calculator.multiply(nonZeroNumber, zero);
        testLog.add("Acted: calculator.multiply() executed");

        // ASSERT: Verify zero product rule
        assertEquals(expectedProduct, actualProduct,
            "Any number multiplied by zero should equal zero");
        assertEquals(0, actualProduct, "Product should be exactly zero");
        testLog.add("Asserted: Zero product rule verified");
    }

    @Test
    @DisplayName("AAA Pattern: Division with Fractional Result")
    void testDivisionWithFractionalResult() {
        // ARRANGE: Prepare division that results in a fraction
        int dividend = 7;
        int divisor = 2;
        double expectedQuotient = 3.5;
        double tolerance = 0.001; // For floating-point comparison
        testLog.add("Arranged: " + dividend + " / " + divisor);

        // ACT: Perform division
        double actualQuotient = calculator.divide(dividend, divisor);
        testLog.add("Acted: calculator.divide() executed");

        // ASSERT: Verify fractional result with tolerance
        assertEquals(expectedQuotient, actualQuotient, tolerance,
            "Division of " + dividend + " by " + divisor + " should equal " + expectedQuotient);
        assertTrue(actualQuotient > 3.0 && actualQuotient < 4.0,
            "Result should be between 3.0 and 4.0");
        testLog.add("Asserted: Fractional result verified");
    }

    @Test
    @DisplayName("AAA Pattern: Division by Zero Exception")
    void testDivisionByZeroThrowsException() {
        // ARRANGE: Set up division by zero scenario
        int dividend = 10;
        int invalidDivisor = 0;
        String expectedExceptionMessage = "Division by zero is not allowed";
        testLog.add("Arranged: " + dividend + " / " + invalidDivisor + " (expecting exception)");

        // ACT & ASSERT: Execute and verify exception is thrown
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(dividend, invalidDivisor),
            "Division by zero should throw IllegalArgumentException"
        );
        testLog.add("Acted & Asserted: Exception thrown as expected");

        // ASSERT: Verify exception message
        assertEquals(expectedExceptionMessage, exception.getMessage(),
            "Exception message should match expected text");
        testLog.add("Asserted: Exception message verified");
    }

    @Test
    @DisplayName("AAA Pattern: Even Number Check")
    void testEvenNumberCheck() {
        // ARRANGE: Prepare test cases for even number checking
        int evenNumber = 24;
        int oddNumber = 17;
        testLog.add("Arranged: Testing " + evenNumber + " (even) and " + oddNumber + " (odd)");

        // ACT: Check if numbers are even
        boolean evenResult = calculator.isEven(evenNumber);
        boolean oddResult = calculator.isEven(oddNumber);
        testLog.add("Acted: calculator.isEven() executed for both numbers");

        // ASSERT: Verify even/odd classification
        assertTrue(evenResult, evenNumber + " should be identified as even");
        assertFalse(oddResult, oddNumber + " should be identified as odd");
        
        // Additional assertions
        assertEquals(0, evenNumber % 2, "Even number should have remainder 0 when divided by 2");
        assertEquals(1, oddNumber % 2, "Odd number should have remainder 1 when divided by 2");
        testLog.add("Asserted: Even/odd classification verified");
    }

    @Test
    @DisplayName("AAA Pattern: Factorial Calculation")
    void testFactorialCalculation() {
        // ARRANGE: Set up factorial test cases
        int inputNumber = 5;
        long expectedFactorial = 120; // 5! = 5 * 4 * 3 * 2 * 1 = 120
        testLog.add("Arranged: Calculating factorial of " + inputNumber);

        // ACT: Calculate factorial
        long actualFactorial = calculator.factorial(inputNumber);
        testLog.add("Acted: calculator.factorial() executed");

        // ASSERT: Verify factorial calculation
        assertEquals(expectedFactorial, actualFactorial,
            "Factorial of " + inputNumber + " should equal " + expectedFactorial);
        assertTrue(actualFactorial > 0, "Factorial should be positive");
        
        // Test edge case: factorial of 0 should be 1
        assertEquals(1, calculator.factorial(0), "Factorial of 0 should be 1");
        testLog.add("Asserted: Factorial calculation verified");
    }

    @Test
    @DisplayName("AAA Pattern: Complex Calculation Chain")
    void testComplexCalculationChain() {
        // ARRANGE: Set up a complex calculation scenario
        int a = 10;
        int b = 5;
        int c = 3;
        testLog.add("Arranged: Complex calculation with a=" + a + ", b=" + b + ", c=" + c);

        // ACT: Perform chain of calculations - (a + b) * c - b
        int step1 = calculator.add(a, b);        // 10 + 5 = 15
        int step2 = calculator.multiply(step1, c); // 15 * 3 = 45
        int finalResult = calculator.subtract(step2, b); // 45 - 5 = 40
        testLog.add("Acted: Multi-step calculation completed");

        // ASSERT: Verify each step and final result
        assertEquals(15, step1, "First step (addition) should equal 15");
        assertEquals(45, step2, "Second step (multiplication) should equal 45");
        assertEquals(40, finalResult, "Final result should equal 40");
        
        // Verify the mathematical relationship
        int expectedResult = (a + b) * c - b;
        assertEquals(expectedResult, finalResult, 
            "Complex calculation should match mathematical formula");
        testLog.add("Asserted: Complex calculation chain verified");
    }

    @Nested
    @DisplayName("Test Fixture Verification")
    class TestFixtureVerification {

        @Test
        @DisplayName("Verify Test Fixtures are Fresh for Each Test")
        void verifyFreshFixtures() {
            // ARRANGE: Check initial state of fixtures
            assertNotNull(calculator, "Calculator fixture should be initialized");
            assertNotNull(testLog, "Test log fixture should be initialized");
            
            // ACT: Modify fixtures
            testLog.add("Modified in nested test");
            
            // ASSERT: Verify fixtures are in expected state
            assertTrue(testLog.size() >= 1, "Test log should contain initialization entry");
            assertEquals("Test #" + testCounter, testLog.get(0).split(": ")[1], 
                "First log entry should contain test number");
        }

        @Test
        @DisplayName("Verify Independent Test Execution")
        void verifyIndependentExecution() {
            // ARRANGE: This test should have fresh fixtures despite previous test
            assertNotNull(calculator, "Calculator should be fresh instance");
            
            // ACT: Use calculator
            int result = calculator.add(1, 1);
            
            // ASSERT: Basic functionality works with fresh fixture
            assertEquals(2, result, "Calculator should work correctly with fresh fixture");
            
            // The test log should only contain the setup entry for this test
            // (not entries from previous test due to fresh setup)
            boolean hasOnlySetupEntry = testLog.stream()
                .anyMatch(entry -> entry.contains("Initialized"));
            assertTrue(hasOnlySetupEntry, "Test log should contain setup entry");
        }
    }
}
