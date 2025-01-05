# Inventory Management System

## Overview
This project is an Inventory Management System built with **Spring Boot** and **PostgreSQL**. It provides a RESTful API to manage products, including creating, retrieving, updating, and deleting products. The database is hosted on **Supabase**, and the project includes unit testing for services and repositories using **JUnit 5** and **Mockito**.

---

## Project Setup

### Technology Stack
- **Backend**: Spring Boot
- **Database**: PostgreSQL (hosted on Supabase)
- **Testing**: JUnit 5, Mockito, Spring Boot Test
- **ORM**: JPA/Hibernate

### Prerequisites
Before getting started, ensure the following tools are installed:
- **Java 21+**
- **Maven**
- **Postman** (optional, for API testing)
- **Supabase account** (for database hosting)

### Setup Steps

#### 1. Clone the Repository
```bash
git clone https://github.com/zakariab0/inventory-managment.git
```

#### 2. Configure the `application.properties`
Open the `src/main/resources/application.properties` file and configure the database settings as follows:

```properties
spring.datasource.url=jdbc:postgresql://<supabase-url>:<port>/<database-name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
Replace `<supabase-url>`, `<port>`, `<database-name>`, `<username>`, and `<password>` with your Supabase credentials.

#### 3. Run the Application
Run the Spring Boot application using Maven:
```bash
mvn spring-boot:run
```
The application will start at `http://localhost:8080`.

---

## API Endpoints

### 1. Create a Product
**Endpoint**: `/products`
- **Method**: POST
- **Body**:
```json
{
  "name": "Product Name",
  "description": "Product Description",
  "price": 100.00
}
```

### 2. Get a Product by ID
**Endpoint**: `/products/{id}`
- **Method**: GET

### 3. Update a Product
**Endpoint**: `/products/{id}`
- **Method**: PUT
- **Body**:
```json
{
  "name": "Updated Name",
  "description": "Updated Description",
  "price": 120.00
}
```

### 4. Delete a Product
**Endpoint**: `/products/{id}`
- **Method**: DELETE

---

## Testing

### Unit Testing with JUnit and Mockito
Unit tests are written for the service and repository layers. Example:
```java
@Test
public void testCreateProduct() {
    Product product = new Product("Test Product", "Test Description", 99.99);
    when(productRepository.save(any(Product.class))).thenReturn(product);

    Product savedProduct = productService.saveItem(product);

    assertNotNull(savedProduct);
    assertEquals("Test Product", savedProduct.getName());
}
```

### Testing with Postman
Use Postman to test the API endpoints by sending requests to:
- **POST**: `http://localhost:8080/products`
- **GET**: `http://localhost:8080/products/{id}`
- **PUT**: `http://localhost:8080/products/{id}`
- **DELETE**: `http://localhost:8080/products/{id}`

### Verifying Data
Use the Supabase dashboard to verify that data is correctly added, updated, or deleted.

---

## Conclusion
This project demonstrates how to build a simple Inventory Management System with Spring Boot and PostgreSQL. It covers backend development, database integration, API development, and testing.

---
