# CoderHack

CoderHack is a simple RESTful API project that allows you to perform CRUD (Create, Read, Update, Delete) operations on user entities.

## Features

- Register a new user
- Retrieve a user by ID
- Update a user's score
- Delete a user by ID
- Get a list of all users

## Technologies Used

- Spring Boot
- Spring Data MongoDB
- Lombok

## DataBase Used

- MongoDB

## Setup

1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   ```

2. **Build the Project:**
   ```bash
   cd coder-hack
   mvn clean install
   ```

3. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**
   Once the application is running, you can access the API endpoints using a tool like Postman or by making HTTP requests directly.

## Application Properties

```properties
# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27017/check
```

## API Endpoints

- `POST /users`: Register a new user.
  - Parameters:
    - `name`: Name of the user (String)
  - Returns: Registered user entity.

- `GET /users/userById`: Retrieve a user by ID.
  - Parameters:
    - `userId`: ID of the user (String)
  - Returns: User entity.

- `PUT /users`: Update a user's score.
  - Parameters:
    - `id`: ID of the user (String)
    - `score`: New score value (int)
  - Returns: Updated user entity.

- `DELETE /users`: Delete a user by ID.
  - Parameters:
    - `id`: ID of the user to delete (String)
  - Returns: Success message upon deletion.

- `GET /users`: Get a list of all users.
  - Returns: List of all user entities, sorted by score in descending order.

## Entity Classes

- `UserEntity`: Represents the user entity with fields such as ID, name, score, and badges.

## Exceptions

- `InvalidScore`: Thrown when an invalid score is provided during score update.
- `UserNotFoundException`: Thrown when a user is not found by ID.

## Service and Repository Layers

- `UserService`: Service interface defining operations for user management.
- `UserServiceImp`: Implementation of `UserService` containing business logic.
- `RepositoryImp`: Spring Data MongoDB repository interface for interacting with the MongoDB database.

## Unit Test Class
- `UserServiceImpTest`: Unit tests for the `UserServiceImp` class, covering methods such as `addUser`, `getUserById`, `updateScore`, and `getAllUsers`.

## Main Application Class
- `Main`: Main class to run the Spring Boot application
## Contributors
 -`[Kishore Thalisetty]:`https://github.com/kishorethalisetty/
