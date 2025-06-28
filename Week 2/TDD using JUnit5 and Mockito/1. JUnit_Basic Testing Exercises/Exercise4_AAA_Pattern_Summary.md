# Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods

## Key Concepts Implemented

### 1. Arrange-Act-Assert (AAA) Pattern

The AAA pattern divides each test into three distinct phases:

- **ARRANGE**: Set up test data, configure objects, and prepare the test environment
- **ACT**: Execute the method or functionality being tested
- **ASSERT**: Verify that the actual results match the expected outcomes

### 2. Test Fixtures

Test fixtures are the fixed state and objects used as a baseline for running tests. They include:

- Shared objects (like Calculator instance)
- Test data
- Configuration settings
- Logging mechanisms

### 3. Setup and Teardown Methods

#### JUnit 5 Annotations:

- `@BeforeAll`: Runs once before all tests in the class (static method)
- `@BeforeEach`: Runs before each test method (equivalent to JUnit 4's `@Before`)
- `@AfterEach`: Runs after each test method (equivalent to JUnit 4's `@After`)
- `@AfterAll`: Runs once after all tests in the class (static method)

## Files Created

### 1. `AAAPatternTest.java`

A comprehensive test class demonstrating:

- **Proper AAA pattern implementation** in each test method
- **Complete test lifecycle management** with setup and teardown
- **Test fixtures** that are initialized fresh for each test
- **Nested test classes** for organizing related tests
- **Various testing scenarios** including edge cases and exception handling

Key features:

```java
@BeforeEach
void setUp() {
    // ARRANGE: Initialize fresh test fixtures for each test
    calculator = new Calculator();
    testLog = new ArrayList<>();
    // ... logging and setup
}

@Test
void testAdditionUsingAAAPattern() {
    // ARRANGE: Set up test data
    int firstNumber = 15;
    int secondNumber = 25;
    int expectedSum = 40;
  
    // ACT: Execute the method under test
    int actualSum = calculator.add(firstNumber, secondNumber);
  
    // ASSERT: Verify the result
    assertEquals(expectedSum, actualSum);
}
```

### 2. `SetupTeardownAAATest.java`

An alternative implementation focusing on:

- **JUnit 4 style naming conventions** (using `before()` and `after()` method names)
- **Detailed logging** of test execution phases
- **State verification** between tests
- **Complex arrange phases** with multi-step setup
- **Fixture independence** verification
