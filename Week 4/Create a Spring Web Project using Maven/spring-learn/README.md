# Spring Web Project using Maven

## Project Structure

```
spring-learn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── spring_learn/
│   │   │               ├── Country.java
│   │   │               ├── SpringLearnApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── CountryController.java
│   │   │               │   └── HelloController.java
│   │   │               └── service/
│   │   │                   └── CountryService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── country.xml
│   └── test/
├── pom.xml
└── README.md
```

## Hands-on Exercises

### Hands-on 1: Hello World RESTful Web Service

- **Endpoint**: `GET /hello`
- **Response**: "Hello World!!"
- **Port**: 8083
- **Screenshots**: See `Outputs Hello World RESTful Web Service/` folder

### Hands-on 2: REST - Country Web Service

- **Endpoint**: `GET /country`
- **Response**: India country details in JSON format
- **Implementation**: Loads country bean from Spring XML configuration
- **Screenshots**: See `Outputs REST - Country Web Service/` folder

### Hands-on 3: REST - Get Country Based on Country Code

- **Endpoint**: `GET /country/{code}`
- **Response**: Specific country details based on country code
- **Features**:
  - Case-insensitive country code matching
  - Supports US, DE, IN, JP country codes
  - Uses lambda expressions for filtering
- **Sample Request**: `http://localhost:8083/country/in`
- **Screenshots**: See `Outputs REST - Get country based on country code/` folder

### Hands-on 4: Spring Core - Load Country from Spring Configuration XML

- **Implementation**: Loads country data from XML configuration file
- **Features**:
  - XML-based Spring configuration
  - ApplicationContext and ClassPathXmlApplicationContext usage
  - Bean injection and property setting
  - Debug logging for constructor and method calls
- **Screenshots**: See `Hands on 1 Outputs/` and `Hands on 2 Outputs/` folders

## Technical Details

### Dependencies

- Spring Boot 3.5.3
- Spring Web
- Spring Context
- Spring Boot DevTools
- Java 17

### Configuration

- **Port**: 8083
- **Logging**: DEBUG level for com.cognizant.spring_learn package
- **XML Configuration**: country.xml with multiple country beans

### Country Data

The application supports the following countries:

- **US** - United States
- **DE** - Germany
- **IN** - India
- **JP** - Japan

## Running the Application

1. **Compile the project**:

   ```bash
   mvn clean compile
   ```
2. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```
3. **Access the endpoints**:

   - Hello World: `http://localhost:8083/hello`
   - India Country: `http://localhost:8083/country`
   - Country by Code: `http://localhost:8083/country/{code}`

## API Endpoints

| Method | Endpoint            | Description                   | Response   |
| ------ | ------------------- | ----------------------------- | ---------- |
| GET    | `/hello`          | Returns Hello World message   | Plain text |
| GET    | `/country`        | Returns India country details | JSON       |
| GET    | `/country/{code}` | Returns country by code       | JSON       |

## Sample Responses

### GET /hello

```
Hello World!!
```

### GET /country or GET /country/in

```json
{
  "code": "IN",
  "name": "India"
}
```

### GET /country/us

```json
{
  "code": "US",
  "name": "United States"
}
```

## Screenshots

Screenshots demonstrating the working application are available in the following folders:

- `Hands on 1 Outputs/` - Spring Core XML configuration outputs
- `Hands on 2 Outputs/` - Additional Spring Core outputs
- `Outputs Hello World RESTful Web Service/` - Hello endpoint screenshots
- `Outputs REST - Country Web Service/` - Country endpoint screenshots
- `Outputs REST - Get country based on country code/` - Dynamic country endpoint screenshots
- Output Create authentication service that returns JWT

Each folder contains both Postman and web browser screenshots showing the API responses.
