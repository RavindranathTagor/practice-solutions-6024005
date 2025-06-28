package com.example.service;

import com.example.api.ExternalApi;


public class MyService {
    
    private final ExternalApi externalApi;
    
    /**
     * Constructor injection - the external API dependency is injected here.
     * @param externalApi the external API dependency
     */
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    /**
     * Fetches data using the external API.
     * This method calls the external API and returns the result.
     * @return the data fetched from external API
     */
    public String fetchData() {
        return externalApi.getData();
    }
    
    /**
     * Processes data by fetching it from external API and adding a prefix.
     * @return processed data with "Processed: " prefix
     */
    public String processData() {
        String data = externalApi.getData();
        return "Processed: " + data;
    }
    
    /**
     * Fetches data by ID using the external API.
     * @param id the ID of the data to fetch
     * @return the data for the specified ID
     */
    public String fetchDataById(String id) {
        return externalApi.getDataById(id);
    }
    
    /**
     * Saves data and returns a confirmation message.
     * @param data the data to save
     * @return confirmation message
     */
    public String saveData(String data) {
        boolean success = externalApi.saveData(data);
        return success ? "Data saved successfully" : "Failed to save data";
    }
    
    /**
     * Updates existing data.
     * @param id the ID of the data to update
     * @param newData the new data
     * @return confirmation message
     */
    public String updateData(String id, String newData) {
        boolean success = externalApi.updateData(id, newData);
        return success ? "Data updated successfully" : "Failed to update data";
    }
    
    /**
     * Validates and saves data (example of method that calls API with validation).
     * @param data the data to validate and save
     * @return validation and save result
     */
    public String validateAndSave(String data) {
        if (data == null || data.trim().isEmpty()) {
            return "Validation failed: Data cannot be empty";
        }
        
        boolean success = externalApi.saveData(data.trim());
        return success ? "Data validated and saved" : "Save failed after validation";
    }
}
