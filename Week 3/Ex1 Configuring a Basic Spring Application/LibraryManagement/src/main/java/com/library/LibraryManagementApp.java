package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Loading Spring Application Context...");
        
        try {
            // Load Spring context from XML configuration
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            
            System.out.println("Spring context loaded successfully!");
            
            // Get BookService bean from Spring context
            BookService bookService = (BookService) context.getBean("bookService");
            
            System.out.println("\n=== Testing Library Operations ===");
            
            // Display initial library information
            bookService.displayLibraryInfo();
            
            // Test adding a new book
            System.out.println("\n--- Adding new books ---");
            bookService.addNewBook("The Catcher in the Rye");
            bookService.addNewBook("Brave New World");
            
            bookService.addNewBook("2007"); 
            bookService.addNewBook("2007"); 
          
            System.out.println("\n--- Searching for books ---");
            bookService.searchBook("2007");
            bookService.searchBook("Nonexistent Book");
            
          
            System.out.println("\n--- Updated Library Status ---");
            bookService.displayLibraryInfo();
            
        
            System.out.println("\n--- Removing a book ---");
            bookService.removeBook("Pride and Prejudice");
            
           
            System.out.println("\n--- Final Library Status ---");
            bookService.displayLibraryInfo();
            
            System.out.println("\n=== Application completed successfully! ===");
            
        } catch (Exception e) {
            System.err.println("Error occurred while running the application: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
