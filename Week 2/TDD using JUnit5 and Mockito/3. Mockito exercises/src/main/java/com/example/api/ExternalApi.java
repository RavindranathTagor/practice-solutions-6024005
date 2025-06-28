package com.example.api;


public interface ExternalApi {
    
    /**
     * Retrieves data from the external source.
     * @return String data from the external API
     */
    String getData();
    
    /**
     * Retrieves data by ID from the external source.
     * @param id the ID of the data to retrieve
     * @return String data for the specified ID
     */
    String getDataById(String id);
    
    /**
     * Saves data to the external source.
     * @param data the data to save
     * @return boolean indicating success
     */
    boolean saveData(String data);
    
    /**
     * Updates data in the external source.
     * @param id the ID of the data to update
     * @param data the new data
     * @return boolean indicating success
     */
    boolean updateData(String id, String data);
}
