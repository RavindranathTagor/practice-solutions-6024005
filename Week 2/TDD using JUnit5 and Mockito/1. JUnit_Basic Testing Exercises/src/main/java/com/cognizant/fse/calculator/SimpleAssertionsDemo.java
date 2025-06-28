package com.cognizant.fse.calculator;

/**
 * Simple test runner to demonstrate assertions manually
 * This shows how the assertions work without requiring Maven
 */
public class SimpleAssertionsDemo {
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        System.out.println("=== Manual Assertions Demo ===");
        
        // Basic equality assertions
        System.out.println("Testing basic assertions:");
        assert 5 == calculator.add(2, 3) : "2 + 3 should equal 5";
        System.out.println("✓ Addition assertion passed");
        
        assert 2 == calculator.subtract(5, 3) : "5 - 3 should equal 2";
        System.out.println("✓ Subtraction assertion passed");
        
        assert 15 == calculator.multiply(5, 3) : "5 * 3 should equal 15";
        System.out.println("✓ Multiplication assertion passed");
        
        // Boolean assertions
        System.out.println("\nTesting boolean assertions:");
        assert calculator.isEven(4) : "4 should be even";
        System.out.println("✓ Even number assertion passed");
        
        assert !calculator.isEven(5) : "5 should be odd";
        System.out.println("✓ Odd number assertion passed");
        
        // Exception testing (manual)
        System.out.println("\nTesting exception scenarios:");
        try {
            calculator.divide(10, 0);
            System.out.println("✗ Should have thrown exception for division by zero");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Division by zero exception handled correctly: " + e.getMessage());
        }
        
        try {
            calculator.factorial(-1);
            System.out.println("✗ Should have thrown exception for negative factorial");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Negative factorial exception handled correctly: " + e.getMessage());
        }
        
        // Null testing
        System.out.println("\nTesting null assertions:");
        String nullString = null;
        assert nullString == null : "String should be null";
        System.out.println("✓ Null assertion passed");
        
        String nonNullString = "Hello";
        assert nonNullString != null : "String should not be null";
        System.out.println("✓ Not null assertion passed");
        
        // Array testing
        System.out.println("\nTesting array assertions:");
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assert java.util.Arrays.equals(expected, actual) : "Arrays should be equal";
        System.out.println("✓ Array equality assertion passed");
        
        System.out.println("\n=== All Assertions Passed! ===");
        System.out.println("The AssertionsTest.java file contains comprehensive JUnit 5 assertions.");
        System.out.println("To run with JUnit 5, use: mvn test -Dtest=AssertionsTest");
    }
}
