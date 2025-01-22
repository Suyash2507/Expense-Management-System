Multi-Tenant Expense Management System
Tech Stack: Spring Boot, Hibernate, PostgreSQL (multi-tenancy), JWT Authentication, RabbitMQ, AWS S3.

# Expense Management System

## Overview

This is a **Spring Boot** application designed for managing expenses. It includes user authentication via **JWT** (JSON Web Tokens), expense management, and integrates with **PostgreSQL** for data persistence. The project allows users to register, log in, and manage their expenses through a simple API.

### Features

- **JWT Authentication**: Secure login and API access using JWT tokens.
- **User Registration**: Register new users with password encryption (using BCrypt).
- **Expense Management**: Add, view, and delete expenses.
- **PostgreSQL Database Integration**: Stores user and expense data in PostgreSQL.

---

## Table of Contents

- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
- [Folder Structure](#folder-structure)
- [Database Setup](#database-setup)
- [Security](#security)
- [Contributing](#contributing)

---

## Technologies Used

- **Spring Boot**: Framework used for building the RESTful application.
- **Spring Security**: For authentication and authorization.
- **JWT (JSON Web Token)**: For secure authentication.
- **PostgreSQL**: Relational database for storing user and expense data.
- **BCrypt**: Password hashing algorithm.
- **Maven**: Dependency management and build automation.
  
---

## Setup Instructions

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/expense-management-system.git
cd expense-management-system
```

### 2. Install Dependencies

Make sure you have **Java 17** or later and **Maven** installed.

To install dependencies, run the following Maven command:

```bash
mvn clean install
```

### 3. Configure PostgreSQL Database

1. Install **PostgreSQL** if you don't have it installed already.
2. Create a new database for the project, e.g., `expense_management`.
3. Update the `application.properties` file located in `src/main/resources` with your PostgreSQL database credentials:

```properties
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/expense_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the Application

You can run the application using the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## API Documentation

### 1. **User Registration**

**POST** `/auth/register`

Register a new user. The request body should include the following fields:

- `username`: The username of the user.
- `password`: The password of the user.
- `email`: The email of the user.

**Request Body**:

```json
{
  "username": "john_doe",
  "password": "password123",
  "email": "john.doe@example.com"
}
```

**Response**:

```json
{
  "message": "User registered successfully!"
}
```

---

### 2. **User Login**

**POST** `/auth/login`

Log in with an existing user. Provide the `username` and `password` in the request body.

**Request Body**:

```json
{
  "username": "john_doe",
  "password": "password123"
}
```

**Response**:

```json
{
  "token": "Bearer <JWT_TOKEN>"
}
```

---

### 3. **Get All Expenses**

**GET** `/expenses`

Retrieve a list of all expenses for the authenticated user.

**Response**:

```json
[
  {
    "id": 1,
    "description": "Coffee",
    "amount": 4.5,
    "date": "2022-08-10T15:53:00Z",
    "category": "Food"
  },
  {
    "id": 2,
    "description": "Taxi",
    "amount": 20.0,
    "date": "2022-08-11T08:30:00Z",
    "category": "Transport"
  }
]
```

---

### 4. **Create a New Expense**

**POST** `/expenses`

Create a new expense. The request body should include the following fields:

- `description`: The description of the expense.
- `amount`: The amount of the expense.
- `date`: The date of the expense (ISO 8601 format).
- `category`: The category of the expense.

**Request Body**:

```json
{
  "description": "Lunch",
  "amount": 12.0,
  "date": "2022-08-12T12:30:00Z",
  "category": "Food"
}
```

**Response**:

```json
{
  "id": 3,
  "description": "Lunch",
  "amount": 12.0,
  "date": "2022-08-12T12:30:00Z",
  "category": "Food"
}
```

---

### 5. **Delete an Expense**

**DELETE** `/expenses/{id}`

Delete an existing expense by its `id`.

**Response**:

```json
{
  "message": "Expense deleted successfully!"
}
```

---

## Folder Structure

Here’s a breakdown of the important files and folders in the project:

```
- src/
  - main/
    - java/
      - com/
        - example/
          - expense/
            - controller/
              - AuthController.java    # Handles login & registration
              - ExpenseController.java # Manages expense operations
            - model/
              - User.java              # Represents a user
              - Expense.java           # Represents an expense
            - repository/
              - UserRepository.java    # Manages user data
              - ExpenseRepository.java # Manages expense data
            - service/
              - UserService.java       # Handles user-related logic
              - ExpenseService.java    # Handles expense-related logic
              - AuthService.java       # Handles authentication logic
            - security/
              - JwtTokenUtil.java      # Utility for JWT token generation
              - JwtAuthenticationFilter.java # Filter for JWT authentication
            - ExpenseApplication.java   # Main Spring Boot Application
    - resources/
      - application.properties  # Database and JWT configuration
```

---

## Database Setup

Make sure to set up your PostgreSQL database properly. You can use the default configuration or change the `application.properties` to suit your needs. The database tables will be created automatically when you run the application.

---

## Security

The project uses **Spring Security** with **JWT** to authenticate and authorize users. The `JwtAuthenticationFilter` intercepts requests and validates the JWT token, while the `JwtTokenUtil` is used to generate and validate JWT tokens.

---
