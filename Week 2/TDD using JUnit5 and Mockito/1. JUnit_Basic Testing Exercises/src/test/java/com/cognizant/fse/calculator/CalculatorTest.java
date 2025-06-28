package com.cognizant.fse.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Calculator demonstrating various JUnit 5 features.
 * This includes basic assertions, parameterized tests, nested test classes,
 * and exception testing.
 */
@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should add two positive numbers correctly")
        void shouldAddTwoPositiveNumbers() {
            // Given
            int a = 5;
            int b = 3;

            // When
            int result = calculator.add(a, b);

            // Then
            assertEquals(8, result, "5 + 3 should equal 8");
        }

        @Test
        @DisplayName("Should add negative numbers correctly")
        void shouldAddNegativeNumbers() {
            assertEquals(-8, calculator.add(-5, -3));
        }

        @Test
        @DisplayName("Should add zero correctly")
        void shouldAddZero() {
            assertEquals(5, calculator.add(5, 0));
            assertEquals(5, calculator.add(0, 5));
        }

        @ParameterizedTest
        @DisplayName("Should add various number combinations")
        @CsvSource({
            "1, 2, 3",
            "10, 20, 30",
            "-5, 5, 0",
            "0, 0, 0"
        })
        void shouldAddVariousNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.add(a, b));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Should subtract two positive numbers correctly")
        void shouldSubtractTwoPositiveNumbers() {
            assertEquals(2, calculator.subtract(5, 3));
        }

        @Test
        @DisplayName("Should handle negative results")
        void shouldHandleNegativeResults() {
            assertEquals(-2, calculator.subtract(3, 5));
        }

        @ParameterizedTest
        @CsvSource({
            "10, 5, 5",
            "0, 5, -5",
            "5, 0, 5"
        })
        void shouldSubtractVariousNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Should multiply two positive numbers correctly")
        void shouldMultiplyTwoPositiveNumbers() {
            assertEquals(15, calculator.multiply(5, 3));
        }

        @Test
        @DisplayName("Should handle multiplication by zero")
        void shouldHandleMultiplicationByZero() {
            assertEquals(0, calculator.multiply(5, 0));
            assertEquals(0, calculator.multiply(0, 5));
        }

        @Test
        @DisplayName("Should handle negative multiplication")
        void shouldHandleNegativeMultiplication() {
            assertEquals(-15, calculator.multiply(-5, 3));
            assertEquals(-15, calculator.multiply(5, -3));
            assertEquals(15, calculator.multiply(-5, -3));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide two numbers correctly")
        void shouldDivideTwoNumbers() {
            assertEquals(2.5, calculator.divide(5, 2), 0.001);
        }

        @Test
        @DisplayName("Should throw exception when dividing by zero")
        void shouldThrowExceptionWhenDividingByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(5, 0),
                "Division by zero should throw IllegalArgumentException"
            );
            assertEquals("Division by zero is not allowed", exception.getMessage());
        }

        @Test
        @DisplayName("Should handle division resulting in whole numbers")
        void shouldHandleDivisionResultingInWholeNumbers() {
            assertEquals(5.0, calculator.divide(10, 2));
        }
    }

    @Nested
    @DisplayName("Even Number Tests")
    class EvenNumberTests {

        @ParameterizedTest
        @DisplayName("Should identify even numbers correctly")
        @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2, -4})
        void shouldIdentifyEvenNumbers(int number) {
            assertTrue(calculator.isEven(number), number + " should be even");
        }

        @ParameterizedTest
        @DisplayName("Should identify odd numbers correctly")
        @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
        void shouldIdentifyOddNumbers(int number) {
            assertFalse(calculator.isEven(number), number + " should be odd");
        }
    }

    @Nested
    @DisplayName("Factorial Tests")
    class FactorialTests {

        @Test
        @DisplayName("Should calculate factorial of zero")
        void shouldCalculateFactorialOfZero() {
            assertEquals(1, calculator.factorial(0));
        }

        @Test
        @DisplayName("Should calculate factorial of one")
        void shouldCalculateFactorialOfOne() {
            assertEquals(1, calculator.factorial(1));
        }

        @ParameterizedTest
        @DisplayName("Should calculate factorial of positive numbers")
        @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
        })
        void shouldCalculateFactorialOfPositiveNumbers(int input, long expected) {
            assertEquals(expected, calculator.factorial(input));
        }

        @Test
        @DisplayName("Should throw exception for negative numbers")
        void shouldThrowExceptionForNegativeNumbers() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.factorial(-1),
                "Factorial of negative number should throw IllegalArgumentException"
            );
            assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Calculator instance should not be null")
    void calculatorShouldNotBeNull() {
        assertNotNull(calculator, "Calculator instance should not be null");
    }
}
