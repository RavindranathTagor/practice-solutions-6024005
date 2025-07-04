package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing book data operations
 */
public class BookRepository {
    
    private List<String> books;
    
    public BookRepository() {
        this.books = new ArrayList<>();
        // Initialize with some sample books
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
        System.out.println("BookRepository bean created successfully!");
    }
    
    /**
     * Get all books from the repository
     * @return List of book titles
     */
    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    /**
     * Add a new book to the repository
     * @param bookTitle The title of the book to add
     */
    public void addBook(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Book added: " + bookTitle);
    }
    
    /**
     * Remove a book from the repository
     * @param bookTitle The title of the book to remove
     * @return true if book was removed, false if not found
     */
    public boolean removeBook(String bookTitle) {
        boolean removed = books.remove(bookTitle);
        if (removed) {
            System.out.println("Book removed: " + bookTitle);
        } else {
            System.out.println("Book not found: " + bookTitle);
        }
        return removed;
    }
    
    /**
     * Find a book by title
     * @param bookTitle The title to search for
     * @return true if book exists, false otherwise
     */
    public boolean findBook(String bookTitle) {
        return books.contains(bookTitle);
    }
    
    /**
     * Get the total number of books
     * @return The count of books in the repository
     */
    public int getBookCount() {
        return books.size();
    }
}
