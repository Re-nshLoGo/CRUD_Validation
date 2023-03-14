# User Management System
## CRUD_Validation

This project is a User Management System built with Spring Boot. It includes endpoints to add, retrieve, update, and delete users, and uses an H2 database for data storage.

#### User Attributes -
Each user has the following attributes:

    UserId
    username
    DateOfBirth
    email
    Phone Number
    Date
    Time
    endpoint
    Endpoints
    
#### The following endpoints are available:

* /addUser - adds a new user
* /getUser/{userid} - retrieves a user by their ID
* /getAllUser - retrieves all users
* /updateUserInfo - updates user information
* /deleteUser - deletes a user

#### Validation is included on the API using 4 different Spring Boot annotations. The following fields are validated:

    @NotBlank
    @Email
    @Length (12 digits with country code as first two digits)
    @Valid

### Getting Started
To run the project, clone the repository and open it in your IDE of choice. Then, run the ValidationApplication.java file.
