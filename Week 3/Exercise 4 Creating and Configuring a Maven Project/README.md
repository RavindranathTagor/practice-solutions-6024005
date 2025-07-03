# Exercise 4: Creating and Configuring a Maven Project

This project demonstrates a basic Maven setup for Java.

## Structure
- `src/main/java` - Application source code
- `src/test/java` - Unit tests
- `pom.xml` - Maven configuration

## Build and Run
To build the project, run:
```
mvn clean install
```
To run the application:
```
mvn exec:java -Dexec.mainClass="com.example.App"
```
