package com.example.service;

import com.example.api.ExternalApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Exercise 2: Verifying Interactions
 * 
 * This test class demonstrates how to verify that methods are called with specific arguments
 * and how to verify the number of times methods are called using Mockito.
 * 
 * Key Concepts:
 * 1. Basic verification: verify(mock).method()
 * 2. Verification with specific arguments: verify(mock).method("expected-arg")
 * 3. Verification with argument matchers: verify(mock).method(anyString())
 * 4. Verification with times: verify(mock, times(n)).method()
 * 5. Verification that methods were never called: verify(mock, never()).method()
 */
public class MyServiceInteractionTest {

    @Mock
    private ExternalApi mockApi;
    
    private MyService service;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new MyService(mockApi);
    }
    
    @Test
    @DisplayName("Exercise 2: Basic interaction verification")
    public void testVerifyInteraction() {
        // Arrange - Set up the test data
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act - Call the method under test
        service.fetchData();
        
        // Verify - Check that the mock was called
        verify(mockApi).getData();
    }
    
    @Test
    @DisplayName("Verify method called with specific arguments")
    public void testVerifyWithSpecificArguments() {
        // Arrange
        String expectedId = "123";
        when(mockApi.getDataById(expectedId)).thenReturn("Data for 123");
        
        // Act
        service.fetchDataById(expectedId);
        
        // Verify - Check that the method was called with the exact argument
        verify(mockApi).getDataById("123");
        verify(mockApi).getDataById(eq("123")); // Alternative using eq() matcher
    }
    
    @Test
    @DisplayName("Verify method called with any string argument")
    public void testVerifyWithArgumentMatchers() {
        // Arrange
        when(mockApi.getDataById(anyString())).thenReturn("Some data");
        
        // Act
        service.fetchDataById("any-id");
        
        // Verify - Check that the method was called with any string argument
        verify(mockApi).getDataById(anyString());
    }
    
    @Test
    @DisplayName("Verify exact number of method calls")
    public void testVerifyNumberOfCalls() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act - Call the method multiple times
        service.fetchData();
        service.fetchData();
        service.processData(); // This also calls getData()
        
        // Verify - Check that getData was called exactly 3 times
        verify(mockApi, times(3)).getData();
    }
    
    @Test
    @DisplayName("Verify method was never called")
    public void testVerifyNeverCalled() {
        // Act - Call only fetchData, not any save methods
        when(mockApi.getData()).thenReturn("Mock Data");
        service.fetchData();
        
        // Verify - Check that saveData was never called
        verify(mockApi, never()).saveData(anyString());
        verify(mockApi, never()).updateData(anyString(), anyString());
        
        // But getData was called once
        verify(mockApi, times(1)).getData();
    }
    
    @Test
    @DisplayName("Verify method called at least/at most certain times")
    public void testVerifyAtLeastAtMost() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act
        service.fetchData();
        service.fetchData();
        
        // Verify - Check that getData was called at least once and at most 3 times
        verify(mockApi, atLeast(1)).getData();
        verify(mockApi, atMost(3)).getData();
        verify(mockApi, atLeastOnce()).getData();
    }
    
    @Test
    @DisplayName("Verify save operation with specific data")
    public void testVerifySaveWithSpecificData() {
        // Arrange
        String testData = "Important data";
        when(mockApi.saveData(testData)).thenReturn(true);
        
        // Act
        String result = service.saveData(testData);
        
        // Assert the result
        assertEquals("Data saved successfully", result);
        
        // Verify - Check that saveData was called with the exact data
        verify(mockApi).saveData("Important data");
        verify(mockApi, times(1)).saveData(testData);
    }
    
    @Test
    @DisplayName("Verify update operation with multiple arguments")
    public void testVerifyUpdateWithMultipleArguments() {
        // Arrange
        String id = "user123";
        String newData = "Updated information";
        when(mockApi.updateData(id, newData)).thenReturn(true);
        
        // Act
        String result = service.updateData(id, newData);
        
        // Assert
        assertEquals("Data updated successfully", result);
        
        // Verify - Check that updateData was called with both specific arguments
        verify(mockApi).updateData("user123", "Updated information");
        verify(mockApi).updateData(eq(id), eq(newData));
    }
    
    @Test
    @DisplayName("Verify validation and save with argument processing")
    public void testVerifyValidationAndSave() {
        // Arrange
        String inputData = "  test data  "; // Data with spaces
        String trimmedData = "test data";   // Expected trimmed data
        when(mockApi.saveData(trimmedData)).thenReturn(true);
        
        // Act
        String result = service.validateAndSave(inputData);
        
        // Assert
        assertEquals("Data validated and saved", result);
        
        // Verify - Check that saveData was called with trimmed data, not original
        verify(mockApi).saveData(trimmedData);
        verify(mockApi, never()).saveData(inputData); // Original data should not be passed
    }
    
    @Test
    @DisplayName("Verify no interactions when validation fails")
    public void testVerifyNoInteractionOnValidationFailure() {
        // Act - Pass invalid data (empty string)
        String result = service.validateAndSave("");
        
        // Assert
        assertEquals("Validation failed: Data cannot be empty", result);
        
        // Verify - Check that no methods were called on the mock
        verifyNoInteractions(mockApi);
    }
    
    @Test
    @DisplayName("Verify order of method calls")
    public void testVerifyOrderOfCalls() {
        // Arrange
        when(mockApi.getDataById("1")).thenReturn("Data 1");
        when(mockApi.saveData("Modified Data 1")).thenReturn(true);
        
        // Act - Call methods in a specific order
        service.fetchDataById("1");
        service.saveData("Modified Data 1");
        
        // Verify - Check the order of calls using InOrder
        org.mockito.InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getDataById("1");
        inOrder.verify(mockApi).saveData("Modified Data 1");
    }
}
