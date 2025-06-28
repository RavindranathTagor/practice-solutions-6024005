package com.example.service;

import com.example.api.ExternalApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;
    
    private MyService service;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new MyService(mockApi);
    }
    
    @Test
    @DisplayName("Test external API mocking and stubbing")
    public void testExternalApi() {
        // Arrange: Stub the mock to return predefined data
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act: Call the method under test
        String result = service.fetchData();
        
        // Assert: Verify the result
        assertEquals("Mock Data", result);
        
        // Verify: Check that the mock was called exactly once
        verify(mockApi, times(1)).getData();
    }
    
    @Test
    @DisplayName("Test external API with different mock data")
    public void testExternalApiWithDifferentData() {
        // Arrange: Stub the mock to return different data
        when(mockApi.getData()).thenReturn("Different Mock Data");
        
        // Act: Call the method under test
        String result = service.fetchData();
        
        // Assert: Verify the result
        assertEquals("Different Mock Data", result);
        
        // Verify: Check that the mock was called
        verify(mockApi).getData();
    }
    
    @Test
    @DisplayName("Test processData method with mocked external API")
    public void testProcessData() {
        // Arrange: Stub the mock to return test data
        when(mockApi.getData()).thenReturn("Test Data");
        
        // Act: Call the processData method
        String result = service.processData();
        
        // Assert: Verify the processed result
        assertEquals("Processed: Test Data", result);
        
        // Verify: Check that the mock was called exactly once
        verify(mockApi, times(1)).getData();
    }
    
    @Test
    @DisplayName("Test multiple calls to external API")
    public void testMultipleCalls() {
        // Arrange: Stub the mock to return data
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act: Call the method multiple times
        service.fetchData();
        service.fetchData();
        service.processData();
        
        // Verify: Check that the mock was called exactly 3 times
        verify(mockApi, times(3)).getData();
    }
    
    @Test
    @DisplayName("Test with manual mock creation (alternative approach)")
    public void testWithManualMock() {
        // Arrange: Create mock manually (alternative to @Mock annotation)
        ExternalApi manualMock = mock(ExternalApi.class);
        when(manualMock.getData()).thenReturn("Manual Mock Data");
        
        MyService manualService = new MyService(manualMock);
        
        // Act: Call the method under test
        String result = manualService.fetchData();
        
        // Assert: Verify the result
        assertEquals("Manual Mock Data", result);
        
        // Verify: Check interaction
        verify(manualMock).getData();
    }
}
