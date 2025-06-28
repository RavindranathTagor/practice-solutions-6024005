# Mockito Exercises 1 & 2: Mocking, Stubbing, and Verifying Interactions

## Scenarios

- **Exercise 1**: Mock external dependencies and stub their methods for basic testing
- **Exercise 2**: Verify that methods are called with specific arguments and in the expected manner

## Project Structure

```
src/
├── main/java/com/example/
│   ├── api/
│   │   ├── ExternalApi.java          # Interface for external API
│   │   └── ExternalApiImpl.java      # Real implementation for demo
│   ├── service/
│   │   └── MyService.java            # Service class under test
│   └── Main.java                     # Demo application
└── test/java/com/example/service/
    ├── MyServiceTest.java            # Exercise 1: Basic mocking and stubbing
    └── MyServiceInteractionTest.java # Exercise 2: Interaction verification
```

## Key Concepts Demonstrated

### Exercise 1: Mocking and Stubbing

1. **Mock Creation**

   - **@Mock annotation**: `@Mock private ExternalApi mockApi;`
   - **Manual creation**: `ExternalApi mock = mock(ExternalApi.class);`
2. **Stubbing**

   - **Basic stubbing**: `when(mockApi.getData()).thenReturn("Mock Data");`
   - **Different return values**: Stub the same method to return different values in different tests
3. **Basic Verification**

   - **Simple verification**: `verify(mockApi).getData();`
   - **Times verification**: `verify(mockApi, times(3)).getData();`

### Exercise 2: Verifying Interactions

1. **Argument Verification**

   - **Specific arguments**: `verify(mockApi).getDataById("123");`
   - **Argument matchers**: `verify(mockApi).saveData(anyString());`
   - **Multiple arguments**: `verify(mockApi).updateData("id", "data");`
2. **Call Count Verification**

   - **Exact times**: `verify(mockApi, times(2)).getData();`
   - **At least/most**: `verify(mockApi, atLeast(1)).getData();`
   - **Never called**: `verify(mockApi, never()).saveData(anyString());`
3. **Advanced Verification**

   - **No interactions**: `verifyNoInteractions(mockApi);`
   - **Order verification**: `InOrder inOrder = inOrder(mockApi);`

## Running the Tests

### Prerequisites

- Java 11 or higher
- Maven

### Commands

```bash
# Compile the project
mvn compile

# Run the demo application
mvn exec:java

# Run all tests
mvn test

# Run specific test classes
mvn test -Dtest=MyServiceTest
mvn test -Dtest=MyServiceInteractionTest

# Run a specific test method
mvn test -Dtest=MyServiceTest#testExternalApi
mvn test -Dtest=MyServiceInteractionTest#testVerifyInteraction
```
