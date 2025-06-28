package com.example;

import com.example.api.ExternalApi;
import com.example.api.ExternalApiImpl;
import com.example.service.MyService;


public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Mockito Exercise 1 & 2: Mocking, Stubbing, and Verifying Interactions Demo ===\n");
        
        // Create a real implementation of the external API
        ExternalApi realApi = new ExternalApiImpl();
        
        // Create the service with the real implementation
        MyService service = new MyService(realApi);
        
        // Use the service - Exercise 1: Basic functionality
        System.out.println("=== Exercise 1: Basic Mocking and Stubbing ===");
        System.out.println("fetchData(): " + service.fetchData());
        System.out.println("processData(): " + service.processData());
        
        // Exercise 2: Methods with parameters for interaction verification
        System.out.println("\n=== Exercise 2: Methods for Interaction Verification ===");
        System.out.println("fetchDataById('123'): " + service.fetchDataById("123"));
        System.out.println("saveData('sample data'): " + service.saveData("sample data"));
        System.out.println("updateData('456', 'new data'): " + service.updateData("456", "new data"));
        System.out.println("validateAndSave('  valid data  '): " + service.validateAndSave("  valid data  "));
        System.out.println("validateAndSave(''): " + service.validateAndSave(""));
        
        System.out.println("\n=== In tests, we use mocks instead of real implementations ===");
        System.out.println("Run 'mvn test' to see:");
        System.out.println("- Exercise 1: Mocked behavior in MyServiceTest");
        System.out.println("- Exercise 2: Interaction verification in MyServiceInteractionTest");
    }
}
