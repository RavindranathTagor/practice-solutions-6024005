# Banking Microservices

A collection of Spring Boot microservices for a banking application demonstrating microservices architecture.

```
Banking Microservices
├── Account Service (Port 8080)
│   └── GET /accounts/{number}
└── Loan Service (Port 8081)
    └── GET /loans/{number}
```

# Output ScreenShots in respective folders

### 1. Account Microservice

- **Port**: 8080
- **Base URL**: http://localhost:8080
- **Endpoint**: `/accounts/{number}`
- **Purpose**: Retrieve account information

### 2. Loan Microservice

- **Port**: 8081
- **Base URL**: http://localhost:8081
- **Endpoint**: `/loans/{number}`
- **Purpose**: Retrieve loan information

## Build All Services

```bash
# Build Account Service
cd account
mvn clean package
cd ..

# Build Loan Service
cd loan
mvn clean package
cd ..
```

### Run All Services

**Terminal 1 - Account Service:**

```bash
cd account
java -jar target/account-0.0.1-SNAPSHOT.jar
```

**Terminal 2 - Loan Service:**

```bash
cd loan
java -jar target/loan-0.0.1-SNAPSHOT.jar
```

## API Testing

### Account Service Test

```bash
curl http://localhost:8080/accounts/00987987973432
```

**Expected Response:**

```json
{
    "number": "00987987973432",
    "type": "savings",
    "balance": 234343
}
```

### Loan Service Test

```bash
curl http://localhost:8081/loans/H00987987972342
```

**Expected Response:**

```json
{
    "number": "H00987987972342",
    "type": "car",
    "loan": 400000,
    "emi": 3258,
    "tenure": 18
}
```

## Browser Testing

Open these URLs in your browser:

1. **Account Service**: http://localhost:8080/accounts/00987987973432
2. **Loan Service**: http://localhost:8081/loans/H00987987972342
