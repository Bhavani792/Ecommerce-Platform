# E-Commerce Backend System

## Overview

This project is a backend application developed using Java, Spring Boot, and MySQL. I built this project to improve my practical understanding of backend development and implement concepts such as REST APIs, authentication, authorization, database integration, Docker, and CI workflows.

The application provides APIs for user registration, login, and product management. JWT authentication is used to secure APIs, and role-based access control is implemented for Admin and User roles.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Maven
- Docker
- GitHub Actions
- Postman
- Git

## Features

- User Registration
- User Login
- JWT Authentication
- Role-Based Authorization (Admin/User)
- Product Management APIs
- MySQL Database Integration
- Docker Containerization
- Basic CI Pipeline using GitHub Actions

## Project Structure

- Controller Layer – Handles API requests
- Service Layer – Contains business logic
- Repository Layer – Handles database operations
- Security Layer – JWT authentication and authorization
- Entity Layer – Database table mapping

## Authentication Flow

1. User registers with username and password.
2. Password is encrypted before storing in the database.
3. User logs in using credentials.
4. JWT token is generated after successful login.
5. The token is sent in the Authorization header for protected APIs.
6. Spring Security validates the token before allowing access.

## API Endpoints

### Authentication APIs

| Method | Endpoint |
|----------|----------|
| POST | /auth/register |
| POST | /auth/login |

### Product APIs

| Method | Endpoint |
|----------|----------|
| GET | /products |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

## Project Flow

```text
Client Request
      ↓
JWT Validation
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
MySQL Database
      ↓
Response Returned
```
## Sample Output

### User Registration

Request:

```json
{
  "username": "john",
  "password": "john123",
  "role": "USER"
}
```

Response:

```json
{
  "message": "User registered successfully"
}
```

---

### User Login

Request:

```json
{
  "username": "john",
  "password": "john123"
}
```

Response:

```json
{
  "token": "JWT_TOKEN_GENERATED"
}
```

---

### Get Products

Request:

```http
GET /products
Authorization: Bearer JWT_TOKEN_GENERATED
```

Response:

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 50000
  },
  {
    "id": 2,
    "name": "Mobile",
    "price": 20000
  }
]
```

---

### Database Records

Users Table

| id | username | role |
|----|----------|------|
| 1 | admin | ADMIN |
| 2 | john | USER |

Products Table

| id | name | price |
|----|------|------|
| 1 | Laptop | 50000 |
| 2 | Mobile | 20000 |


## Docker

Build Image:

```bash
docker build -t ecommerce-backend .
```

Run Container:

```bash
docker run -p 8080:8080 ecommerce-backend
```

## CI Workflow

A basic GitHub Actions workflow is configured to automatically build the project and Docker image whenever code is pushed to the repository.

## What I Learned

- Building REST APIs using Spring Boot
- Implementing JWT authentication and authorization
- Working with MySQL and Spring Data JPA
- Testing APIs using Postman
- Understanding Docker basics
- Setting up a basic CI workflow using GitHub Actions
- Organizing backend applications using layered architecture
