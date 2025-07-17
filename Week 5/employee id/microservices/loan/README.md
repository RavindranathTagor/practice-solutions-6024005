# Loan Microservice

A Spring Boot microservice for handling bank loan operations.

## Technology Stack

- **Java**: 17
- **Spring Boot**: 3.5.3
- **Spring Web**: For REST API
- **Spring Boot DevTools**: For development
- **Maven**: Build tool

## Project Structure

```
loan/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/loan/
│   │   │       ├── LoanApplication.java
│   │   │       ├── controller/
│   │   │       │   └── LoanController.java
│   │   │       └── model/
│   │   │           └── Loan.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/cognizant/loan/
│               └── LoanApplicationTests.java
├── pom.xml
└── README.md
```

## API Endpoints

### Get Loan Details

**URL:** `GET /loans/{number}`

**Description:** Retrieves loan information for the given loan number.

**Parameters:**

- `number` (Path Parameter): The loan number

**Example Request:**

```bash
curl http://localhost:8081/loans/H00987987972342
```

**Example Response:**

```json
{
    "number": "H00987987972342",
    "type": "car",
    "loan": 400000,
    "emi": 3258,
    "tenure": 18
}
```

**Response Status:** `200 OK`

### Build the Application

```bash
mvn clean package
```

### Run the Application

```bash
java -jar target/loan-0.0.1-SNAPSHOT.jar
```

Or using Maven:

```bash
mvn spring-boot:run
```

### Configuration

- **Port:** 8081 (configured in application.properties)
- **Context Path:** /
- **Base URL:** http://localhost:8081

## Configuration Details

The `application.properties` file contains:

```properties
server.port=8081
```

This ensures the loan service runs on port 8081, avoiding conflicts with the account service (port 8080).

## Testing

### Unit Tests

```bash
mvn test
```

### Manual Testing

Once the application is running, you can test the API using:

1. **Browser:** Navigate to `http://localhost:8081/loans/H00987987972342`
2. **curl:** `curl http://localhost:8081/loans/H00987987972342`.
