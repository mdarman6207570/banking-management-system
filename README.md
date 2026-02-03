# Banking Management System

A backend-focused Spring Boot Banking Management System designed to demonstrate clean architecture, JPA entity relationships, and real-world banking domain modeling.

This project implements a One-to-One relationship between Customer and Account using Spring Data JPA and Hibernate, following industry best practices and enterprise-level design principles.

---

## Technology Stack
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- Maven
- Oracle Database
- Lombok

---

## Project Overview
The Banking Management System is a backend application that models core banking concepts such as customers and their accounts. The project focuses on proper entity design, database mapping, and layered architecture, making it suitable for demonstrating backend development skills in interviews and resumes.

---

## Key Features
- Developed a Spring Boot backend application using Java 21
- Implemented One-to-One mapping between Customer and Account entities
- Used Spring Data JPA and Hibernate for ORM and database interaction
- Designed entities with proper constraints and relationships
- Followed layered architecture (Controller, Service, Repository)
- Maven-based project structure for build and dependency management
- Database-ready design aligned with real-world banking systems

---

## Project Structure

src
└── main
├── java
│ └── com.arman.bms
│ ├── entity
│ │ ├── Customer.java
│ │ └── Account.java
│ ├── repository
│ ├── service
│ └── controller
└── resources
└── application.properties


---

## 🔗 Entity Relationship Design
- One Customer is associated with exactly one Account
- One Account belongs to exactly one Customer
- Relationship implemented using `@OneToOne` mapping
- Foreign key managed at the Account level
- Database constraints ensure data consistency

---

## ▶️ How to Run the Project
1. Clone the repository
   ```bash
   git clone https://github.com/mdarman6207570/banking-management-system.git

2. Open the project in IntelliJ IDEA or Eclipse

3. Configure database properties in application.properties

4. Run the Spring Boot application

5. Test APIs using Postman or browser



🔮 Future Enhancements

Transaction management module

Fund transfer between accounts

JWT-based authentication and authorization

Role-based access control (Admin / Customer)

Swagger / OpenAPI documentation

Exception handling and validation layer
