# Library Management System - Spring Framework Exercise

This is a basic Spring application demonstrating dependency injection and XML-based configuration for a library management system.

## Project Structure

```
LibraryManagement/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── library/
│       │           ├── LibraryManagementApp.java    (Main class)
│       │           ├── service/
│       │           │   └── BookService.java         (Service layer)
│       │           └── repository/
│       │               └── BookRepository.java      (Data access layer)
│       └── resources/
│           └── applicationContext.xml                (Spring configuration)
```

## Features

- **Spring Core Integration**: Uses Spring Framework for dependency injection
- **XML Configuration**: Beans configured using applicationContext.xml
- **Service Layer**: BookService handles business logic
- **Repository Layer**: BookRepository manages data operations
- **Dependency Injection**: BookRepository is injected into BookService via setter injection

## How to Run

1. **Compile the project:**

   ```bash
   mvn clean compile
   ```
2. **Run the application:**

   ```bash
   mvn exec:java -Dexec.mainClass="com.library.LibraryManagementApp"
   ```

   Or compile and run manually:

   ```bash
   mvn clean compile
   java -cp "target/classes;C:\Users\%USERNAME%\.m2\repository\org\springframework\spring-core\5.3.21\*;C:\Users\%USERNAME%\.m2\repository\org\springframework\spring-context\5.3.21\*;C:\Users\%USERNAME%\.m2\repository\org\springframework\spring-beans\5.3.21\*;C:\Users\%USERNAME%\.m2\repository\org\springframework\spring-expression\5.3.21\*" com.library.LibraryManagementApp
   ```
