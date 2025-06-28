package com.cognizant.fse.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Exercise 4: Alternative demonstration using JUnit 4 style naming conventions
 * while using JUnit 5 annotations.
 * 
 * Note: In JUnit 5, @Before is @BeforeEach and @After is @AfterEach
 * This class demonstrates the AAA pattern with setup and teardown methods
 * using more traditional naming conventions.
 */
@DisplayName("JUnit 4 Style Setup/Teardown with AAA Pattern")
class SetupTeardownAAATest {

    // Test fixtures
    private Calculator calculator;
    private String testStartTime;
    private StringBuilder testExecutionLog;
    
    // Static counter for tracking test execution
    private static int totalTestsExecuted = 0;

    /**
     * Setup method that runs before each test (equivalent to @Before in JUnit 4)
     * Initializes test fixtures and prepares the test environment.
     */
    @BeforeEach
    void before() { // Using 'before' to simulate JUnit 4 @Before naming
        // Initialize test fixtures
        calculator = new Calculator();
        testExecutionLog = new StringBuilder();
        testStartTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        
        // Log setup
        testExecutionLog.append("SETUP: Test initialized at ").append(testStartTime).append("\n");
        System.out.println("BEFORE: Setting up test fixtures at " + testStartTime);
    }

    /**
     * Teardown method that runs after each test (equivalent to @After in JUnit 4)
     * Cleans up test fixtures and logs test completion.
     */
    @AfterEach
    void after() { // Using 'after' to simulate JUnit 4 @After naming
        totalTestsExecuted++;
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        
        // Log teardown
        testExecutionLog.append("TEARDOWN: Test completed at ").append(endTime).append("\n");
        System.out.println("AFTER: Cleaning up test fixtures. Total tests executed: " + totalTestsExecuted);
        
        // Verify fixtures exist during teardown
        assertNotNull(calculator, "Calculator should exist during teardown");
        assertNotNull(testExecutionLog, "Test log should exist during teardown");
        
        // Clean up
        calculator = null;
        testExecutionLog = null;
        testStartTime = null;
    }

    @Test
    @DisplayName("AAA: Basic Addition with Setup/Teardown Logging")
    void testBasicAdditionWithLogging() {
        // ARRANGE: Prepare test data and log the arrangement
        int operand1 = 12;
        int operand2 = 8;
        int expectedSum = 20;
        testExecutionLog.append("ARRANGE: Set up addition test with ")
                       .append(operand1).append(" + ").append(operand2).append("\n");

        // ACT: Execute the operation under test
        testExecutionLog.append("ACT: Executing calculator.add()\n");
        int actualSum = calculator.add(operand1, operand2);

        // ASSERT: Verify the result and log the assertion
        testExecutionLog.append("ASSERT: Verifying result equals ").append(expectedSum).append("\n");
        assertEquals(expectedSum, actualSum, 
            "Addition of " + operand1 + " and " + operand2 + " should equal " + expectedSum);
        
        // Additional verification
        assertTrue(actualSum > 0, "Sum should be positive");
        System.out.println("Test execution log:\n" + testExecutionLog.toString());
    }

    @Test
    @DisplayName("AAA: Subtraction with Boundary Testing")
    void testSubtractionBoundaryValues() {
        // ARRANGE: Set up boundary value test cases
        testExecutionLog.append("ARRANGE: Setting up boundary value subtraction tests\n");
        
        // Test case 1: Positive result
        int large = 100;
        int small = 30;
        int expectedPositive = 70;

        // ACT: Execute first subtraction
        testExecutionLog.append("ACT: Executing positive result subtraction\n");
        int positiveResult = calculator.subtract(large, small);

        // ASSERT: Verify positive result
        testExecutionLog.append("ASSERT: Verifying positive result\n");
        assertEquals(expectedPositive, positiveResult, "Large - small should give positive result");
        assertTrue(positiveResult > 0, "Result should be positive");

        // ARRANGE: Set up zero result test
        testExecutionLog.append("ARRANGE: Setting up zero result test\n");
        int sameNumber = 42;

        // ACT: Execute zero result subtraction
        testExecutionLog.append("ACT: Executing zero result subtraction\n");
        int zeroResult = calculator.subtract(sameNumber, sameNumber);

        // ASSERT: Verify zero result
        testExecutionLog.append("ASSERT: Verifying zero result\n");
        assertEquals(0, zeroResult, "Number minus itself should equal zero");
        
        System.out.println("Boundary test execution log:\n" + testExecutionLog.toString());
    }

    @Test
    @DisplayName("AAA: Multiplication Edge Cases with Detailed Logging")
    void testMultiplicationEdgeCases() {
        // ARRANGE: Prepare multiple edge case scenarios
        testExecutionLog.append("ARRANGE: Preparing multiplication edge cases\n");

        // Edge case 1: Multiplication by 1 (identity)
        int number = 25;
        int identity = 1;

        // ACT: Test multiplication identity
        testExecutionLog.append("ACT: Testing multiplication by 1 (identity)\n");
        int identityResult = calculator.multiply(number, identity);

        // ASSERT: Verify identity property
        testExecutionLog.append("ASSERT: Verifying identity property\n");
        assertEquals(number, identityResult, "Number multiplied by 1 should equal itself");

        // ARRANGE: Edge case 2 - Multiplication by negative
        testExecutionLog.append("ARRANGE: Setting up negative multiplication\n");
        int positive = 15;
        int negative = -4;
        int expectedNegativeProduct = -60;

        // ACT: Execute negative multiplication
        testExecutionLog.append("ACT: Executing negative multiplication\n");
        int negativeResult = calculator.multiply(positive, negative);

        // ASSERT: Verify negative result
        testExecutionLog.append("ASSERT: Verifying negative multiplication result\n");
        assertEquals(expectedNegativeProduct, negativeResult, 
            "Positive times negative should give negative result");
        assertTrue(negativeResult < 0, "Result should be negative");

        System.out.println("Multiplication edge cases log:\n" + testExecutionLog.toString());
    }

    @Test
    @DisplayName("AAA: Division Precision and Exception Handling")
    void testDivisionPrecisionAndExceptions() {
        // ARRANGE: Set up precision test
        testExecutionLog.append("ARRANGE: Setting up division precision test\n");
        int dividend = 22;
        int divisor = 7;
        double expectedQuotient = 22.0 / 7.0; // Approximately 3.142857...

        // ACT: Execute division
        testExecutionLog.append("ACT: Executing precision division\n");
        double actualQuotient = calculator.divide(dividend, divisor);

        // ASSERT: Verify precision
        testExecutionLog.append("ASSERT: Verifying division precision\n");
        assertEquals(expectedQuotient, actualQuotient, 0.000001, 
            "Division should maintain precision");
        assertTrue(actualQuotient > 3.14 && actualQuotient < 3.15, 
            "Result should be approximately π");

        // ARRANGE: Set up exception test
        testExecutionLog.append("ARRANGE: Setting up division by zero exception test\n");
        int numerator = 50;
        int zeroDivisor = 0;

        // ACT & ASSERT: Test exception handling
        testExecutionLog.append("ACT & ASSERT: Testing division by zero exception\n");
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> calculator.divide(numerator, zeroDivisor),
            "Division by zero should throw IllegalArgumentException");

        assertNotNull(exception.getMessage(), "Exception should have a message");
        assertTrue(exception.getMessage().contains("zero"), 
            "Exception message should mention zero");

        System.out.println("Division test execution log:\n" + testExecutionLog.toString());
    }

    @Test
    @DisplayName("AAA: State Verification Between Tests")
    void testStateVerificationBetweenTests() {
        // ARRANGE: Verify fresh state from setup
        testExecutionLog.append("ARRANGE: Verifying fresh test state\n");
        assertNotNull(calculator, "Calculator should be freshly initialized");
        assertNotNull(testStartTime, "Start time should be recorded");
        assertTrue(testExecutionLog.toString().contains("SETUP"), 
            "Log should contain setup entry");

        // ACT: Perform operation and modify state
        testExecutionLog.append("ACT: Performing operation to modify state\n");
        int result = calculator.add(10, 5);
        testExecutionLog.append("State modified with calculation result: ").append(result).append("\n");

        // ASSERT: Verify operation and state
        testExecutionLog.append("ASSERT: Verifying operation and state\n");
        assertEquals(15, result, "Calculation should be correct");
        assertTrue(testExecutionLog.length() > 50, "Log should have accumulated content");
        
        // Verify that this test has fresh fixtures (not affected by previous tests)
        String logContent = testExecutionLog.toString();
        long setupCount = logContent.lines().filter(line -> line.contains("SETUP")).count();
        assertEquals(1, setupCount, "Should have exactly one setup entry (fresh state)");

        System.out.println("State verification log:\n" + testExecutionLog.toString());
    }

    /**
     * Test to demonstrate that each test method gets fresh fixtures
     * due to @BeforeEach and @AfterEach execution
     */
    @Test
    @DisplayName("AAA: Fixture Independence Verification")
    void testFixtureIndependence() {
        // ARRANGE: Verify independence of test fixtures
        testExecutionLog.append("ARRANGE: Verifying fixture independence\n");
        
        // Each test should start with a fresh calculator instance
        assertNotNull(calculator, "Calculator should be fresh instance");
        
        // Test should have its own log instance
        String initialLogContent = testExecutionLog.toString();
        assertTrue(initialLogContent.contains("SETUP"), "Should contain setup log");

        // ACT: Perform operations that would affect state
        testExecutionLog.append("ACT: Performing state-affecting operations\n");
        
        // Multiple operations
        int sum = calculator.add(1, 2);
        int product = calculator.multiply(sum, 3);
        boolean isEven = calculator.isEven(product);

        // ASSERT: Verify operations and independence
        testExecutionLog.append("ASSERT: Verifying operations and independence\n");
        assertEquals(3, sum, "Sum should be correct");
        assertEquals(9, product, "Product should be correct");
        assertFalse(isEven, "9 should not be even");

        // Verify this test's log is independent
        String finalLogContent = testExecutionLog.toString();
        assertTrue(finalLogContent.length() > initialLogContent.length(), 
            "Log should have grown during test");
        
        // Count the number of SETUP entries - should be exactly 1 for this test
        long setupEntries = finalLogContent.lines()
            .filter(line -> line.contains("SETUP"))
            .count();
        assertEquals(1, setupEntries, "Should have exactly one setup entry per test");

        System.out.println("Independence verification log:\n" + testExecutionLog.toString());
    }

    /**
     * Demonstration of testing with complex arrange phase
     */
    @Test
    @DisplayName("AAA: Complex Arrange Phase with Multiple Setup Steps")
    void testComplexArrangePhase() {
        // ARRANGE: Complex setup with multiple steps
        testExecutionLog.append("ARRANGE: Starting complex multi-step setup\n");
        
        // Step 1: Prepare base values
        int baseValue = 10;
        testExecutionLog.append("ARRANGE Step 1: Base value = ").append(baseValue).append("\n");
        
        // Step 2: Calculate intermediate values
        int doubledValue = calculator.multiply(baseValue, 2);
        testExecutionLog.append("ARRANGE Step 2: Doubled value = ").append(doubledValue).append("\n");
        
        // Step 3: Prepare expected results
        int expectedSum = baseValue + doubledValue; // 10 + 20 = 30
        int expectedDifference = doubledValue - baseValue; // 20 - 10 = 10
        testExecutionLog.append("ARRANGE Step 3: Expected sum = ").append(expectedSum)
                       .append(", Expected difference = ").append(expectedDifference).append("\n");

        // ACT: Execute the operations under test
        testExecutionLog.append("ACT: Executing operations under test\n");
        int actualSum = calculator.add(baseValue, doubledValue);
        int actualDifference = calculator.subtract(doubledValue, baseValue);

        // ASSERT: Verify all results
        testExecutionLog.append("ASSERT: Verifying all calculated results\n");
        assertEquals(expectedSum, actualSum, "Sum should match expected value");
        assertEquals(expectedDifference, actualDifference, "Difference should match expected value");
        
        // Additional assertions based on mathematical relationships
        assertEquals(baseValue * 3, actualSum, "Sum should equal base value times 3");
        assertEquals(baseValue, actualDifference, "Difference should equal base value");
        
        // Verify the relationship between arranged and acted values
        assertEquals(doubledValue, baseValue * 2, "Doubled value should be twice the base");

        System.out.println("Complex arrange phase log:\n" + testExecutionLog.toString());
    }
}
