# Ecommerce Microservices Project

## Overview

This project is an ecommerce application built using microservices architecture with Spring Boot.
It consists of several services that interact to provide various functionalities including customer management, product catalog, order processing, payment handling, and notifications.

## Services

1. **Customer Service**: Manages customer information and authentication.
2. **Products Service**: Handles product catalog management and availability.
3. **Order Service**: Manages orders placed by customers.
4. **Payment Service**: Handles payment processing for orders.
5. **Notification Service**: Sends notifications to customers about order and payment updates.

## Technologies Used

- **Spring Boot**: Framework for creating microservices in Java.
- **MySQL**: Database for storing customer, product, order, and payment data.
- **MongoDB**: Database for storing notification details.
- **Kafka**: Messaging system for asynchronous communication between services.
- **Docker**: Containerization platform used to run Kafka, Zookeeper, and development mail server.
- **Spring Cloud Config**: Centralized configuration management for microservices.
- **Eureka**: Service registration and discovery for microservices.
- **API Gateway**: Centralized entry point for accessing all services.

## Setup Instructions

1. **Prerequisites**:
   - JDK 11 or higher
   - Docker Desktop (for running Kafka and Zookeeper)
   - MySQL and MongoDB installed locally or accessible remotely

2. **Running the Services**:
   - Clone the repository from [GitHub](https://github.com/hemanthvinod).
   - Build each service using Maven or Gradle.
   - Start MySQL and MongoDB databases.
   - Start Kafka and Zookeeper using Docker.
   - Start each microservice in the following order:
     - Config Server
     - Eureka Discovery Server
     - Customer Service
     - Products Service
     - Order Service
     - Payment Service
     - Notification Service
     - API Gateway

3. **Configuration**:
   - Update application properties or environment variables as necessary for database connections, Kafka configuration, etc.

4. **Testing**:
   - Use tools like Postman to test API endpoints exposed by each service.
   - Verify integration between services through Kafka messaging.

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
