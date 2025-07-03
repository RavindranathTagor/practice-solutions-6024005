package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;


public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService bean created successfully!");
    }
    
    /**
     * Setter method for dependency injection
     * @param bookRepository The BookRepository to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService!");
    }
    
    /**
     * Get all available books
     * @return List of all book titles
     */
    public List<String> listAllBooks() {
        System.out.println("Fetching all books from the library...");
        return bookRepository.getAllBooks();
    }
    
    /**
     * Add a new book to the library
     * @param bookTitle The title of the book to add
     */
    public void addNewBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty!");
            return;
        }
        
        if (bookRepository.findBook(bookTitle)) {
            System.out.println("Warning: Book '" + bookTitle + "' already exists in the library!");
        } else {
            bookRepository.addBook(bookTitle);
            System.out.println("Successfully added book: " + bookTitle);
        }
    }
    
    /**
     * Remove a book from the library
     * @param bookTitle The title of the book to remove
     */
    public void removeBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty!");
            return;
        }
        
        boolean removed = bookRepository.removeBook(bookTitle);
        if (removed) {
            System.out.println("Successfully removed book: " + bookTitle);
        } else {
            System.out.println("Book not found in library: " + bookTitle);
        }
    }
    
    /**
     * Search for a book in the library
     * @param bookTitle The title to search for
     * @return true if book exists, false otherwise
     */
    public boolean searchBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty!");
            return false;
        }
        
        boolean found = bookRepository.findBook(bookTitle);
        if (found) {
            System.out.println("Book found: " + bookTitle);
        } else {
            System.out.println("Book not found: " + bookTitle);
        }
        return found;
    }
    
    /**
     * Get library statistics
     */
    public void displayLibraryInfo() {
        int totalBooks = bookRepository.getBookCount();
        System.out.println("=== Library Information ===");
        System.out.println("Total books in library: " + totalBooks);
        System.out.println("Available books:");
        List<String> books = bookRepository.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("==========================");
    }
}
