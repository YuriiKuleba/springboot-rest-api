# Getting Started

### Clone the application
* Application requires Java v17+ to run. Install the repository locally or run with IDE
* https://github.com/YuriiKuleba/springboot-rest-api.git

### Create and define databases

+ This application uses two different databases to obtain a list of users.
+ In our case we use MySQL and PostgreSQL
+ Scripts for creating a database are in the file:
```bash
src/main/resources/createDBs.txt
``` 
+ For define database, we have to write its properties in the file which located
  in resources folder:
```bash
data-source-parameters.yaml
 ``` 
+ To add more databases, just add their properties to the configuration file.

### Build and Run Application

+ Run app with SpringbootRestApplication.class

+ The app will start running at http://localhost:8080.

### Explore Rest APIs. The app defines following CRUD APIs:

    GET http://localhost:8080/api/users
    GET http://localhost:8080/api/users/{id}

    OpenAPI: http://localhost:8080/swagger-ui/index.html
    API-docs: http://localhost:8080/api-docs
