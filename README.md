#  Library Microservices Project

A microservices-based **Library Management System** built with **Spring Boot**, featuring service discovery, centralized configuration, and API gateway routing.  
The system allows managing users, books, and rental orders across independent services.

---

## Architecture Overview

This project follows a **microservices architecture** and includes the following components:

### **Services**
| Service | Description |
|--------|-------------|
| **user-service** | Manages users of the library (registration, lookup, details). |
| **book-service** | Handles book catalog, availability, and book metadata. |
| **order-service** | Manages renting/returning books and order history. |
| **api-gateway** | Entry point for all client requests; routes traffic to services. |
| **eureka-server** | Service discovery for all microservices. |
| **config-server** | Provides centralized configuration to all services. |

A `gitrepo` folder is included to store configuration for the Config Server.

---

## Technologies Used
- **Java / Spring Boot**
- **Spring Cloud Netflix (Eureka, Gateway)**
- **Spring Cloud Config**
- **Docker & Docker Compose**
- **MySQL** (configured in docker-compose)
- **Maven**
