package com.example.api;

/**
 * A concrete implementation of ExternalApi for demonstration purposes.
 * In a real application, this might make HTTP calls to an actual external service.
 */
public class ExternalApiImpl implements ExternalApi {
    
    @Override
    public String getData() {
        // In a real implementation, this might make an HTTP call
        // For demo purposes, we'll just return a hardcoded value
        return "Real data from external API";
    }
    
    @Override
    public String getDataById(String id) {
        // Simulate getting data by ID
        return "Real data for ID: " + id;
    }
    
    @Override
    public boolean saveData(String data) {
        // Simulate saving data
        System.out.println("Saving data: " + data);
        return true; // Always return success for demo
    }
    
    @Override
    public boolean updateData(String id, String data) {
        // Simulate updating data
        System.out.println("Updating data for ID " + id + " with: " + data);
        return true; // Always return success for demo
    }
}
