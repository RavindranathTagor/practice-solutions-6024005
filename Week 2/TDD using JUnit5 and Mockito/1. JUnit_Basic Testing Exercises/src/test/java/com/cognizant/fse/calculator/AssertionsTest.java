package com.cognizant.fse.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 3: Comprehensive JUnit 5 Assertions Test Class
 * This class demonstrates various types of assertions available in JUnit 5.
 */
@DisplayName("JUnit 5 Assertions Exercise")
class AssertionsTest {

    @Nested
    @DisplayName("Basic Assertions")
    class BasicAssertions {

        @Test
        @DisplayName("Should demonstrate basic equality assertions")
        void testBasicAssertions() {
            // Assert equals - compares two values for equality
            assertEquals(5, 2 + 3, "2 + 3 should equal 5");
            assertEquals("Hello", "Hello", "Strings should be equal");
            assertEquals(3.14, 3.14, 0.001, "Double values should be equal within delta");

            // Assert true - verifies condition is true
            assertTrue(5 > 3, "5 should be greater than 3");
            assertTrue("Hello".startsWith("He"), "String should start with 'He'");

            // Assert false - verifies condition is false
            assertFalse(5 < 3, "5 should not be less than 3");
            assertFalse("Hello".isEmpty(), "String should not be empty");

            // Assert null - verifies value is null
            String nullString = null;
            assertNull(nullString, "String should be null");

            // Assert not null - verifies value is not null
            String nonNullString = "Hello";
            assertNotNull(nonNullString, "String should not be null");
            assertNotNull(new Object(), "New object should not be null");
        }

        @Test
        @DisplayName("Should demonstrate string assertions")
        void testStringAssertions() {
            String actual = "JUnit 5 is awesome";
            String expected = "JUnit 5 is awesome";

            // String equality
            assertEquals(expected, actual);

            // String contains
            assertTrue(actual.contains("JUnit"));
            assertTrue(actual.contains("awesome"));

            // String starts/ends with
            assertTrue(actual.startsWith("JUnit"));
            assertTrue(actual.endsWith("awesome"));

            // Case insensitive comparison
            assertEquals("JUNIT 5 IS AWESOME", actual.toUpperCase());
        }
    }

    @Nested
    @DisplayName("Array and Collection Assertions")
    class ArrayAndCollectionAssertions {

        @Test
        @DisplayName("Should demonstrate array assertions")
        void testArrayAssertions() {
            int[] expected = {1, 2, 3, 4, 5};
            int[] actual = {1, 2, 3, 4, 5};

            // Array equality
            assertArrayEquals(expected, actual, "Arrays should be equal");

            // String arrays
            String[] expectedStrings = {"apple", "banana", "cherry"};
            String[] actualStrings = {"apple", "banana", "cherry"};
            assertArrayEquals(expectedStrings, actualStrings, "String arrays should be equal");
        }

        @Test
        @DisplayName("Should demonstrate collection assertions")
        void testCollectionAssertions() {
            List<String> fruits = Arrays.asList("apple", "banana", "cherry");

            // Collection size
            assertEquals(3, fruits.size(), "List should contain 3 elements");

            // Collection contains
            assertTrue(fruits.contains("apple"), "List should contain 'apple'");
            assertTrue(fruits.contains("banana"), "List should contain 'banana'");
            assertFalse(fruits.contains("grape"), "List should not contain 'grape'");

            // Collection emptiness
            assertFalse(fruits.isEmpty(), "List should not be empty");

            // Test empty collection
            List<String> emptyList = Arrays.asList();
            assertTrue(emptyList.isEmpty(), "Empty list should be empty");
            assertEquals(0, emptyList.size(), "Empty list should have size 0");
        }
    }

    @Nested
    @DisplayName("Exception Assertions")
    class ExceptionAssertions {

        @Test
        @DisplayName("Should demonstrate exception testing")
        void testExceptionAssertions() {
            Calculator calculator = new Calculator();

            // Assert that an exception is thrown
            IllegalArgumentException divisionException = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0),
                "Division by zero should throw IllegalArgumentException"
            );

            // Verify exception message
            assertEquals("Division by zero is not allowed", divisionException.getMessage());

            // Assert that an exception is thrown for negative factorial
            IllegalArgumentException factorialException = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.factorial(-5),
                "Negative factorial should throw IllegalArgumentException"
            );

            assertEquals("Factorial is not defined for negative numbers", factorialException.getMessage());
        }

        @Test
        @DisplayName("Should demonstrate that no exception is thrown")
        void testNoExceptionThrown() {
            Calculator calculator = new Calculator();

            // Assert that no exception is thrown
            assertDoesNotThrow(() -> calculator.add(5, 3), "Addition should not throw exception");
            assertDoesNotThrow(() -> calculator.divide(10, 2), "Valid division should not throw exception");
            assertDoesNotThrow(() -> calculator.factorial(5), "Valid factorial should not throw exception");
        }
    }

    @Nested
    @DisplayName("Advanced Assertions")
    class AdvancedAssertions {

        @Test
        @DisplayName("Should demonstrate timeout assertions")
        void testTimeoutAssertions() {
            // Assert that operation completes within timeout
            assertTimeout(Duration.ofMillis(100), () -> {
                // Simulate quick operation
                Thread.sleep(10);
                return "completed";
            }, "Operation should complete within 100ms");

            // Assert timeout preemptively (stops execution if timeout exceeded)
            assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
                // Quick operation
                return 2 + 2;
            }, "Simple calculation should complete within 50ms");
        }

        @Test
        @DisplayName("Should demonstrate grouped assertions")
        void testGroupedAssertions() {
            Calculator calculator = new Calculator();

            // All assertions are executed, even if some fail
            assertAll("calculator operations",
                () -> assertEquals(8, calculator.add(5, 3), "Addition should work"),
                () -> assertEquals(2, calculator.subtract(5, 3), "Subtraction should work"),
                () -> assertEquals(15, calculator.multiply(5, 3), "Multiplication should work"),
                () -> assertEquals(1.666, calculator.divide(5, 3), 0.001, "Division should work")
            );
        }

        @Test
        @DisplayName("Should demonstrate custom assertion messages")
        void testCustomMessages() {
            Calculator calculator = new Calculator();
            int a = 10;
            int b = 5;

            // Custom message with suppliers (lazy evaluation)
            assertEquals(15, calculator.add(a, b), 
                () -> String.format("Adding %d + %d should equal 15", a, b));

            assertTrue(calculator.isEven(a), 
                () -> String.format("Number %d should be even", a));
        }
    }

    @Nested
    @DisplayName("Calculator-Specific Assertions")
    class CalculatorSpecificAssertions {

        private final Calculator calculator = new Calculator();

        @Test
        @DisplayName("Should test calculator arithmetic operations")
        void testArithmeticOperations() {
            // Test addition
            assertEquals(10, calculator.add(7, 3));
            assertEquals(0, calculator.add(-5, 5));
            assertEquals(-8, calculator.add(-3, -5));

            // Test subtraction
            assertEquals(4, calculator.subtract(7, 3));
            assertEquals(-10, calculator.subtract(-5, 5));
            assertEquals(2, calculator.subtract(-3, -5));

            // Test multiplication
            assertEquals(21, calculator.multiply(7, 3));
            assertEquals(-25, calculator.multiply(-5, 5));
            assertEquals(15, calculator.multiply(-3, -5));
        }

        @Test
        @DisplayName("Should test calculator utility methods")
        void testUtilityMethods() {
            // Test even number detection
            assertTrue(calculator.isEven(2));
            assertTrue(calculator.isEven(0));
            assertTrue(calculator.isEven(-4));
            assertFalse(calculator.isEven(1));
            assertFalse(calculator.isEven(-3));

            // Test factorial
            assertEquals(1, calculator.factorial(0));
            assertEquals(1, calculator.factorial(1));
            assertEquals(24, calculator.factorial(4));
            assertEquals(120, calculator.factorial(5));
        }

        @ParameterizedTest
        @DisplayName("Should test even numbers with parameterized test")
        @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2, -4})
        void testEvenNumbers(int number) {
            assertTrue(calculator.isEven(number), 
                () -> String.format("Number %d should be even", number));
        }

        @ParameterizedTest
        @DisplayName("Should test odd numbers with parameterized test")
        @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
        void testOddNumbers(int number) {
            assertFalse(calculator.isEven(number), 
                () -> String.format("Number %d should be odd", number));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Testing")
    class EdgeCaseAssertions {

        private final Calculator calculator = new Calculator();

        @Test
        @DisplayName("Should test boundary values")
        void testBoundaryValues() {
            // Test with zero
            assertEquals(5, calculator.add(0, 5));
            assertEquals(0, calculator.multiply(0, 100));
            assertTrue(calculator.isEven(0));

            // Test with maximum and minimum integers
            assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
            assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MIN_VALUE, 0));
        }

        @Test
        @DisplayName("Should test division edge cases")
        void testDivisionEdgeCases() {
            // Valid divisions
            assertEquals(2.5, calculator.divide(5, 2), 0.001);
            assertEquals(-2.5, calculator.divide(-5, 2), 0.001);
            assertEquals(0.0, calculator.divide(0, 5), 0.001);

            // Division by zero should throw exception
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(-5, 0));
        }

        @Test
        @DisplayName("Should test factorial edge cases")
        void testFactorialEdgeCases() {
            // Valid factorials
            assertEquals(1, calculator.factorial(0));
            assertEquals(1, calculator.factorial(1));

            // Invalid factorials should throw exception
            assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
            assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-10));
        }
    }
}
