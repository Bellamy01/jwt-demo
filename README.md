## jwt-demo: Secure Your Spring Boot App with JWT Authentication & RBAC

This project demonstrates a Spring Boot application with secure authentication and authorization using JSON Web Tokens (JWT), Role-Based Access Control (RBAC), MySQL database integration, and the jjwt library. Users can register, log in, generate tokens, and access protected resources based on their assigned roles.

### Features

* **JWT Authentication:** Secure user login with JWT for stateless authentication.
* **RBAC Implementation:** Control access to resources based on user roles.
* **MySQL Integration:** Stores user data and roles in a persistent database.
* **jjwt Library:** Handles JWT generation, validation, and parsing.
* **Protected Routes:** Restricts access to specific endpoints based on roles.
* **Clear Architecture:** Well-structured code for maintainability.

### How It Works

#### User Registration: 🆕
Users can create accounts with usernames and passwords.
User roles are assigned during registration.
#### Login Process:
Users provide credentials (username and password) for authentication.
Upon successful login, a JWT token is generated and returned.
#### Token Usage: 🪄
Users include the JWT token in the Authorization header of subsequent requests.
The server validates the token and grants access to authorized resources.
### Role-Based Access Control: ️
Specific endpoints are secured for users with designated roles (e.g., /dashboard for admins).
Unauthorized requests result in access denial responses.

### Prerequisites:

* Java 11+
* Maven or Gradle
* MySQL database server
* Running the Application: ‍♀️

### Clone this repository.
Set up a MySQL database with necessary tables (user, role, etc.).
Configure database connection details in application.properties.
Run the application using: `Bash`
```
mvn spring-boot:run
```
Use code with caution.

> The server will start on port 6000.

### Testing:

#### Login:

Use a POST request to http://localhost:6000/login with JSON credentials in the request body:

JSON
```json
{
  "username": "your_username",
  "password": "your_password"
}
```
>[!NOTE]
>Use code with caution.

#### Successful Login Response:

##### JSON
```json
{
  "token": "your_jwt_token"
}
```
Use code with caution.

### Protected Resource Example:

#### Unprotected Route (/):

Access the root endpoint (/) with any HTTP method (GET, POST, etc.).
This endpoint should be accessible to everyone (Role: ROLE_USER, ROLE_ADMIN).

#### Protected Route (/dashboard):  (Role: ROLE_ADMIN)

Access the /dashboard endpoint with a GET request.
Include the received JWT token in the Authorization header:
`Authorization: Bearer your_jwt_token`
Only users with the "ADMIN" role will be able to access this endpoint.
### Technology Stack: ️

* Spring Boot
* Spring Security
* JWT (jjwt library)
* MySQL

[Optional] Additional libraries for specific functionalities

## Contribution:

We welcome contributions to improve this project. Feel free to fork the repository, make changes, and create pull requests.

## License: ⚖️

This project is licensed under the Apache License 2.0. See the LICENSE file for details.

### Additional Notes:

Consider using environment variables for sensitive information like database credentials.
Implement robust error handling and security best practices for production deployments.
