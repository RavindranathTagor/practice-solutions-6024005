# Account Microservice

A Spring Boot microservice for handling bank account operations.

## Project Structure

```
account/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/account/
│   │   │       ├── AccountApplication.java
│   │   │       ├── controller/
│   │   │       │   └── AccountController.java
│   │   │       └── model/
│   │   │           └── Account.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/cognizant/account/
│               └── AccountApplicationTests.java
├── pom.xml
└── README.md
```

## API Endpoints

### Get Account Details

**URL:** `GET /accounts/{number}`

**Description:** Retrieves account information for the given account number.

**Parameters:**

- `number` (Path Parameter): The account number

**Example Request:**

```bash
curl http://localhost:8080/accounts/00987987973432
```

**Example Response:**

```json
{
    "number": "00987987973432",
    "type": "savings",
    "balance": 234343
}
```

**Response Status:** `200 OK`

## Running the Application

### Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)

### Build the Application

```bash
mvn clean package
```

### Run the Application

```bash
java -jar target/account-0.0.1-SNAPSHOT.jar
```

Or using Maven:

```bash
mvn spring-boot:run
```

### Default Configuration

- **Port:** 8080
- **Context Path:** /
- **Base URL:** http://localhost:8080

## Testing

### Unit Tests

```bash
mvn test
```

### Manual Testing

Once the application is running, you can test the API using:

1. **Browser:** Navigate to `http://localhost:8080/accounts/00987987973432`
