# SLF4J Logging Exercise 1

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/cognizent/fse/
│   │       └── LoggingExample.java
│   └── resources/
│       └── logback.xml
├── pom.xml
└── README.md
```

## Dependencies

- **SLF4J API** (1.7.30): Provides the logging interface
- **Logback Classic** (1.2.3): SLF4J implementation for actual logging

## How to Run

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Running the Application

1. **Compile the project:**

   ```bash
   mvn compile
   ```
2. **Run the application:**

   ```bash
   mvn exec:java -Dexec.mainClass="com.cognizent.fse.LoggingExample"
   ```

   Or alternatively:

   ```bash
   mvn compile exec:java -Dexec.mainClass="com.cognizent.fse.LoggingExample"
   ```
3. **Package and run as JAR:**

   ```bash
   mvn package
   java -cp target/classes:target/dependency/* com.cognizent.fse.LoggingExample
   ```
