package com.cognizant.fse.calculator;

public class Calculator {

    /**
     * Adds two numbers.
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     * @param a dividend
     * @param b divisor
     * @return quotient of a divided by b
     * @throws IllegalArgumentException if divisor is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }

    /**
     * Checks if a number is even.
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Calculates the factorial of a number.
     * @param n the number to calculate factorial for
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Main method for demonstration purposes.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("=== Calculator Demo ===");
        System.out.println("Addition: 5 + 3 = " + calc.add(5, 3));
        System.out.println("Subtraction: 10 - 4 = " + calc.subtract(10, 4));
        System.out.println("Multiplication: 6 * 7 = " + calc.multiply(6, 7));
        System.out.println("Division: 15 / 3 = " + calc.divide(15, 3));
        System.out.println("Is 8 even? " + calc.isEven(8));
        System.out.println("Factorial of 5: " + calc.factorial(5));
        
      
        try {
            calc.divide(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            calc.factorial(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
