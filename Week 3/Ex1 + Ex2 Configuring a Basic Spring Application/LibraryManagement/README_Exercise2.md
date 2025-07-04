# Exercise 2: Implementing Dependency Injection

This exercise demonstrates the implementation of Dependency Injection (DI) using Spring Framework's Inversion of Control (IoC) container in a Library Management application. The goal is to manage dependencies between the `BookService` and `BookRepository` classes using Spring's XML-based configuration.

## Project Structure

```
LibraryManagement/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── library/
│       │           ├── LibraryManagementApp.java     # Main application class
│       │           ├── service/
│       │           │   └── BookService.java          # Service layer with DI
│       │           └── repository/
│       │               └── BookRepository.java       # Data access layer
│       └── resources/
│           └── applicationContext.xml                 # Spring configuration
├── pom.xml                                           # Maven dependencies
└── README_Exercise2.md                              # This documentation
```

## Key Components

### 1. Spring Configuration (`applicationContext.xml`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define BookRepository bean -->
    <bean id="bookRepository" class="com.library.repository.BookRepository">
    </bean>

    <!-- Define BookService bean with dependency injection -->
    <bean id="bookService" class="com.library.service.BookService">
        <property name="bookRepository" ref="bookRepository"/>
    </bean>

</beans>
```

### 2. BookService Class with Setter Injection

```java
public class BookService {
    private BookRepository bookRepository;
  
    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService!");
    }
  
    // Business logic methods using the injected repository
    public List<String> listAllBooks() {
        return bookRepository.getAllBooks();
    }
    // ... other methods
}
```

### 3. BookRepository Class

```java
public class BookRepository {
    private List<String> books;
  
    public BookRepository() {
        this.books = new ArrayList<>();
        // Initialize with sample data
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
    }
  
    // Data access methods
    public List<String> getAllBooks() { /* implementation */ }
    public void addBook(String bookTitle) { /* implementation */ }
    // ... other CRUD operations
}
```

### Types of Dependency Injection Used

1. **Setter-based Injection**: Using setter methods to inject dependencies
2. **XML Configuration**: Externalized configuration for dependency wiring

## How to Run the Application

### Steps to Execute

1. **Navigate to project directory:**

   ```bash
   cd "d:\Cognizent FSE\Week 3\Ex1 Configuring a Basic Spring Application\LibraryManagement"
   ```
2. **Compile the project:**

   ```bash
   mvn clean compile
   ```
3. **Run the application:**

   ```bash
   mvn exec:java
   ```

### Expected Output

```
=== Library Management System ===
Loading Spring Application Context...
BookRepository bean created successfully!
BookService bean created successfully!
BookRepository injected into BookService!
Spring context loaded successfully!

=== Testing Library Operations ===
=== Library Information ===
Total books in library: 4
Available books:
1. The Great Gatsby
2. To Kill a Mockingbird
3. 1984
4. Pride and Prejudice
==========================

--- Adding new books ---
Successfully added book: The Catcher in the Rye
Successfully added book: Brave New World
...
```

## Configuration Details

### Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.21</version>
    </dependency>
    <!-- Other Spring dependencies -->
</dependencies>
```

## Application Output

When running the application with `mvn exec:java`, you can observe the complete dependency injection process and library operations:

```
=== Library Management System ===
Loading Spring Application Context...
BookRepository bean created successfully!
BookService bean created successfully!
BookRepository injected into BookService!
Spring context loaded successfully!

=== Testing Library Operations ===
=== Library Information ===
Total books in library: 4
Available books:
1. The Great Gatsby
2. To Kill a Mockingbird
3. 1984
4. Pride and Prejudice
==========================

--- Adding new books ---
Book added: The Catcher in the Rye
Successfully added book: The Catcher in the Rye
Book added: Brave New World
Successfully added book: Brave New World
Book added: 2007
Successfully added book: 2007
Warning: Book '2007' already exists in the library!

--- Searching for books ---
Book found: 2007
Book not found: Nonexistent Book

--- Updated Library Status ---
=== Library Information ===
Total books in library: 7
Available books:
1. The Great Gatsby
2. To Kill a Mockingbird
3. 1984
4. Pride and Prejudice
5. The Catcher in the Rye
6. Brave New World
7. 2007
==========================

--- Removing a book ---
Book removed: Pride and Prejudice
Successfully removed book: Pride and Prejudice

--- Final Library Status ---
=== Library Information ===
Total books in library: 6
Available books:
1. The Great Gatsby
2. To Kill a Mockingbird
3. 1984
4. The Catcher in the Rye
5. Brave New World
6. 2007
==========================

=== Application completed successfully! ===
```

## Output Analysis

### 1. Functional Verification

The application demonstrates all library management operations:

| Operation                     | Status     | Description                                                    |
| ----------------------------- | ---------- | -------------------------------------------------------------- |
| **Initial Listing**     | ✅ Success | Shows 4 pre-loaded books                                       |
| **Adding Books**        | ✅ Success | Adds "The Catcher in the Rye", "Brave New World", "2007"       |
| **Duplicate Detection** | ✅ Success | Warns when adding duplicate "2007"                             |
| **Book Search**         | ✅ Success | Finds existing book "2007", reports missing "Nonexistent Book" |
| **Book Removal**        | ✅ Success | Removes "Pride and Prejudice" from collection                  |
| **Final Count**         | ✅ Success | Shows updated library with 6 books                             |
