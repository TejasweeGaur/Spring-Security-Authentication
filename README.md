<!-- @format -->

# Spring Boot Authentication Service

This repository contains a simple authentication service built with Spring Boot and Spring Security. The application fetches and persists roles and users to MongoDB. It utilizes various Spring dependencies for enhanced functionality and documentation.

## Dependencies Used

- **Spring Security**: Provides authentication and authorization support for the application.
- **Spring Web**: Enables the development of web applications, including RESTful APIs.
- **Spring Dev Tools**: Facilitates automatic application restarts during development for improved productivity.
- **Lombok**: Reduces boilerplate code in Java classes through annotations.
- **Spring Data MongoDB**: Simplifies the interaction with MongoDB for data storage and retrieval.
- **SpringDoc OpenAI**: Integration for Swagger UI to provide extensive documentation on API endpoints.
- **Therapi Runtime Javadoc**: Enhances in-code JavaDocs for improved code understanding.

## Prerequisites

Ensure you have the following installed:

- **JDK 21**: Java Development Kit version 21.
- **Maven**: Build and dependency management tool.

## Building the Application

To build the application, run the following Maven command:

```bash
mvn clean install
```

**_This will compile the code, run tests, and package the application into a JAR file._**

## Running the Application

After building the application, you can run the JAR file using the following command:

```bash
java -jar target/authentication-service.jar
```

The application will start, and you can access the Swagger UI for detailed information on API endpoints.

## Swagger UI

Visit Swagger UI after starting the application to explore and interact with the API documentation.

`http://localhost:<server_port>/swagger-ui/index.html#/`

## JavaDocs

In-code JavaDocs are available to help users understand the code and method implementations. Refer to the comments in the source code for detailed explanations.

## Contributing

Feel free to contribute to the project by creating issues, suggesting enhancements, or submitting pull requests.

## License

This project is licensed under the MIT License.
