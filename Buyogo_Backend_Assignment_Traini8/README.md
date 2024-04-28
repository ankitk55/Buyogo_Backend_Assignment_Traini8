# Buyogo - Backend Assessment Traini8



<h1 align="center">Buyogo-Traini8</h1>

<p align="center">
    <a href="https://www.java.com/" target="_blank">
        <img src="https://img.shields.io/badge/Java-17-red" alt="Java 17">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
        <img src="https://img.shields.io/badge/Maven-3.8.1-blue" alt="Maven 3.8.1">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/Spring Boot-3.2.5-brightgreen" alt="Spring Boot 3.2.5">
    </a>
  
</a>

</p>

<hr>

## Dependencies

- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa): Provides support for Spring Data JPA, enabling easy interaction with databases using JPA.
- [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation): Includes validation support for Spring MVC applications.
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web): Provides basic web support, including embedded Tomcat server and Spring MVC.
- [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j): JDBC driver for connecting to MySQL databases.
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok): Reduces boilerplate code by providing annotations to generate getters, setters, constructors, and more.
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test): Includes dependencies for testing Spring Boot applications.
- [Springdoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui): Integrates OpenAPI documentation into Spring Boot applications.


## Enpoints

### Register a New Training_Center

- **URL:** `/api/trainingcenter`
- **Method:** `POST`
- **Description:** Register a new Training_Center.
- **Request Body:**
    - JSON object representing the user to be registered.
    - Includes details such as center_name, address, contact_info, etc.
  ```json
  
  {
    "centerName":"Geekster",
    "centerCode":"12345DERT355",
     "centerAddress":
    {   
        "detailedAddress":"HNo-07,Mohalla murtiVihar",
        "city":"khurja",
        "pincode":345611,
        "state":"Uttar pradesh"
    },
    "contactPhone":"+918456787082",
    "contactEmail":"abc@gmail.com",
    "studentCapacity":500,
    "coursesOffered":
    [
        "DSA",
        "JAVA",
        "Python"
    ]
    
  }

- **Response Body:**
    -  If Training_Center is registered successfully return current Training_Center including the ID of the created Training_Center with `Http Status Code :201`.
   ```json
  
  {
    "trainingCenterId": 2,
    "centerName":"Geekster",
    "centerCode":"12345DERT355",
     "centerAddress":
    {   
        "detailedAddress":"HNo-07,Mohalla murtiVihar",
        "city":"khurja",
        "pincode":345611,
        "state":"Uttar pradesh"
    },
    "contactPhone":"+918456787082",
    "contactEmail":"abc@gmail.com",
    "studentCapacity":500,
    "coursesOffered":
    [
        "DSA",
        "JAVA",
        "Python"
    ],
   "createdOn": "2024-04-28T20:18:51.780786"
    
  }
 - Error message if there's an internal server error during user creation.


### Get All Registered Training_Centers

- **URL:** `/api/trainingcenters`
- **Method:** `GET`
- **Description:** Retrieves a list of all Registered Training_Centers.

- **Response Body:**
  - Success Response:
    - Status Code: `200 OK`
    - JSON array containing the details of all Training_Centers.

  ```json
    [
  {
        "trainingCenterId": 1,
        "centerName": "Scaler",
        "centerCode": "1234RTDERT355",
        "centerAddress": {
            "detailedAddress": "A-07,Mohalla Sarita Vihar ",
            "city": "khurja",
            "pincode": "203131",
            "state": "Uttar pradesh"
        },
        "studentCapacity": 500,
        "coursesOffered": [
            "DSA",
            "JAVA",
            "Python"
        ],
        "createdOn": "2024-04-28T20:18:51.780786",
        "contactEmail": "abc@gmail.com",
        "contactPhone": "+919456787082"
    },
    {
        "trainingCenterId": 2,
        "centerName": "Geekster",
        "centerCode": "12345DERT355",
        "centerAddress": {
            "detailedAddress": "HNo-07,Mohalla murtiVihar",
            "city": "Noida",
            "pincode": "345611",
            "state": "Uttar pradesh"
        },
        "studentCapacity": 1000,
        "coursesOffered": [
            "DSA",
            "JAVA",
            "Python"
        ],
        "createdOn": "2024-04-28T20:20:36.378036",
        "contactEmail": "abc@gmail.com",
        "contactPhone": "+918456787082"
    }
   ]

## Validation Rules
- Center_Name can not be `NULL` , should be `UNIQUE` , only less than `40 characters` accepted.
- Cente_Code must not be `BLANK` or `NULL` and only exactly `12 AlphaNumeric Characters` accepted.
- Address must not be `NULL` and all fields of Address are mandatory.
- Contact_Email can be `NULL` But if email is present should be a `Valid Format`.
- Contact_Phone must not be `NULL`. And Phone_Number should be a Valid Format. `eg: +914567897654`, [`+`countryCode`10 digits of Numbers`]


- Error message will show  if there's an validation voilation with `HTTP Status Code: 400`.


## Swagger Support for API Documentation

The project includes Swagger support for API documentation. Swagger is a powerful tool that provides interactive documentation for RESTful APIs, enabling developers to explore and test endpoints easily. By integrating Swagger into your project, you can enhance the usability and understanding of your API, making it easier for developers to integrate with your system.

### Key Benefits of Swagger:
- **Interactive Documentation:** Swagger generates interactive documentation that allows developers to explore and test endpoints directly from the documentation interface.
- **Ease of Integration:** Developers can easily understand and integrate with your API by referring to the comprehensive documentation provided by Swagger.
- **Consistency:** Swagger ensures that the API documentation remains consistent with the actual implementation, reducing the chances of discrepancies.
- **Time-Saving:** With Swagger, developers can quickly understand the API structure and functionalities, saving time on integration and troubleshooting.

### Swagger Configuration

The Swagger configuration (`OpenApiConfig` class) provides support for interactive documentation of RESTful APIs using Swagger. It includes:

- **Info:** Provides general information about the API, such as contact details, description, title, version, license, and terms of service.
- **Servers:** Specifies the servers where the API is hosted, allowing developers to interact with different environments.
- **Security:** Defines security requirements for accessing the API. In this case, it requires bearer token authentication.


## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/ankitk55/Buyogo_Backend_Assignment_Traini8.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Buyogo_Backend_Assignment_Traini8
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## Database Setup

To set up the database for the WishlistManagement application, follow these steps:

1. Open the `application.properties` file in the project's `src/main/resources` directory.

2. Configure the datasource properties according to your MySQL database setup:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/<Your Database Name>?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

   Replace `your_database_username` and `your_database_password` with your MySQL database credentials.

3. Optionally, configure Hibernate properties for SQL logging:
   ```
   spring.jpa.properties.hibernate.show_sql=true
   spring.jpa.properties.hibernate.use_sql_comments=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

   These properties enable SQL logging in the console for debugging purposes.


## Accessing the Application

You can access the application through your web browser by navigating to `http://localhost:8080`.

## Custom Port Configuration

If you need to define your own port for accessing the application, you can do so by configuring it in the `application.properties` file. Simply specify the desired port number in the configuration file, and the application will listen on that port upon startup.

Example:
```properties
server.port=9000
```


## Documentations :
* For Testing Apis  you can use **Postman** [Documentation](https://documenter.getpostman.com/view/27811473/2sA3BuVokU).
* For better understanding of Endpoints and also you can tests All Endpoints with  **Swagger-UI** [Documentation](http://localhost:8080/swagger-ui/index.html#/)
### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!
