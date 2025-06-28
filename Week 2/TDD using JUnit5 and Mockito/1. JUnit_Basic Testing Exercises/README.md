# JUnit 5 Exercise - Setting Up JUnit Testing

This project demonstrates how to set up and use JUnit 5 for unit testing in a Java Maven project.

## Project Structure

```
├── src/
│   ├── main/java/
│   │   └── com/cognizant/fse/calculator/
│   │       └── Calculator.java          # Sample calculator class
│   └── test/java/
│       └── com/cognizant/fse/calculator/
│           └── CalculatorTest.java      # Comprehensive test class
├── pom.xml                              # Maven configuration with JUnit 5
└── README.md                            # This file
```

## Features Demonstrated

### JUnit 5 Features

- **Basic Assertions**: `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`
- **Exception Testing**: `assertThrows` for testing expected exceptions
- **Nested Test Classes**: `@Nested` for organizing related tests
- **Parameterized Tests**: `@ParameterizedTest` with `@ValueSource` and `@CsvSource`
- **Display Names**: `@DisplayName` for descriptive test names
- **Test Lifecycle**: `@BeforeEach` for test setup

### Calculator Class Features

- Basic arithmetic operations (add, subtract, multiply, divide)
- Input validation and exception handling
- Edge case handling (division by zero, negative factorial)
- Utility methods (even number check, factorial calculation)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- VS Code with Java Extension Pack (recommended)

### Running the Project

1. **Compile the project:**

   ```bash
   mvn clean compile
   ```
2. **Run all tests:**

   ```bash
   mvn test
   ```
3. **Run tests with detailed output:**

   ```bash
   mvn test -Dtest=CalculatorTest
   ```
4. **Package the project:**

   ```bash
   mvn clean package
   ```

### Sample Test Structure

```java
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
}
```

### Exercise 3: JUnit 5 Assertions

The `AssertionsTest.java` demonstrates comprehensive usage of JUnit 5 assertions:

#### Basic Assertions
- `assertEquals()` - Compare values for equality
- `assertTrue()` / `assertFalse()` - Test boolean conditions
- `assertNull()` / `assertNotNull()` - Test for null values

#### Advanced Assertions
- `assertArrayEquals()` - Compare arrays
- `assertThrows()` - Test exception scenarios
- `assertDoesNotThrow()` - Verify no exceptions
- `assertTimeout()` - Test execution time
- `assertAll()` - Group multiple assertions

#### Key Features Demonstrated
- **Nested Test Classes**: Organized test structure with `@Nested`
- **Custom Messages**: Descriptive failure messages
- **Parameterized Tests**: Test multiple inputs efficiently
- **Exception Testing**: Proper exception validation
- **Edge Case Testing**: Boundary value testing
- **Timeout Testing**: Performance assertions

#### Running the Assertions Tests
```bash
# Run all assertion tests
mvn test -Dtest=AssertionsTest

# Run specific nested test class
mvn test -Dtest=AssertionsTest$BasicAssertions
```
