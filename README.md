# 🛠️ Spring Boot REST API Project

## 🚀 Overview

This is a robust Spring Boot REST API project that performs full **CRUD operations** on `User` and `Product` models. The API is structured using best practices, including clean separation of concerns with models, DTOs, mappers, and controllers. It’s equipped with an **H2 in-memory database** for fast local testing and development.

---

## 📦 Features

- 🔄 Full Create, Read, Update, Delete functionality for Users and Products
- 📦 Modular DTO-based architecture for clean API communication
- 🔐 Password update functionality via secure request bodies
- 🧪 H2 Database integration for easy testing without setup
- 🧹 Clear separation of concerns with repositories, mappers, and controllers
- ✨ Designed for scalability and easy future enhancements

---

## 🧩 Models

- `User`: Holds user-specific information including login credentials and profile details.
- `Product`: Contains product-related data such as name, description, and category.
- `Category`: Represents product classifications for better organization.

---

## 📤 Data Transfer Objects (DTOs)

- `UserRegisterDTO`: Captures data required to register a new user.
- `UserDataDTO`: Used to expose only the necessary user data (e.g., hides sensitive fields).
- `UpdateUserDTO`: For updating user profile details.
- `ChangePasswordDTO`: Handles password change requests securely.
- `ProductDataDTO`: Represents a structured view of product data returned from APIs.

---

## 🧰 Mappers

- **UserMapper**: Converts between `User`, `UserRegisterDTO`, `UpdateUserDTO`, and `UserDataDTO`.
- **ProductMapper**: Maps `Product` entities to `ProductDataDTO`.

---

## 🗂️ Repositories

- `UserRepository`: Handles all user-related database operations.
- `ProductRepository`: Manages product-related data persistence.

---

## 🌐 REST Controllers

### 📁 UserController

Base Route: `/users`

- `GET /users` – Get all users
- `GET /users/{id}` – Get user by ID
- `POST /users/{id}` – Register a new user
- `PUT /users/{id}/password` – Update user password
- `POST /users/{id}/update` – Update user profile or password using request body
- `DELETE /users/{id}` – Delete user by ID

### 📁 ProductController

Base Route: `/products`

- `GET /products` – Retrieve all products
- `GET /products/{id}` – Retrieve product by ID

---

## 🧪 In-Memory Database

This project uses the **H2 Database**, making it incredibly fast and easy to test without the need for setting up external database systems. The database schema is auto-generated from your entities.

---

## ✅ Getting Started (Optional Section)

To run this project locally:

```bash
git clone [https://github.com/your-repo/springboot-crud-api.git](https://github.com/Animesh0203/Springboot-REST-API-Template.git)
cd springboot-crud-api
./mvnw spring-boot:run
```

The API will be available at http://localhost:8081