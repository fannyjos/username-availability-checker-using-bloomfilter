
# Username Availability Checker

A Spring Boot REST API that checks whether a username is available using a Bloom Filter and MySQL.

## Features

- Username availability checking
- Bloom Filter optimization
- Spring Boot REST API
- MySQL database integration
- JPA/Hibernate ORM

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Google Guava Bloom Filter
- Maven

## API Endpoint

### Check Username Availability

```http
GET /username/{username}
```

### Example

Request:

```http
GET /username/john
```

Response:

```json
{
  "available": false
}
```

Request:

```http
GET /username/david
```

Response:

```json
{
  "available": true
}
```

## Project Structure

```text
src/main/java/com/example/demo

├── controller
├── service
├── repository
├── entity
└── dto
```

## How It Works

1. Client sends a username.
2. Bloom Filter checks if the username might exist.
3. If Bloom Filter says "not present", return available immediately.
4. If Bloom Filter says "might exist", verify using MySQL.
5. Return the final availability status.

## Future Improvements

- Redis-backed Bloom Filter
- Username suggestions
- Swagger/OpenAPI documentation

## Author

Fanny Jose
