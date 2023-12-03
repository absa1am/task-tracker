# task-tracker
Task tracker web app using JSP, Servlet and Java

**Prerequisites**
1. JDK 21
2. Apache Tomcat 10.1.12
3. PostgreSQL

**Installation**
1. Clone the repository
2. Create a database called "jdbc" with username "postgres" and password "123456" if you want to run this project as it is, otherwise modify the configuration in DAO class.
3. Create a table:
    CREATE TABLE Tasks (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        description VARCHAR(500),
        start_date DATE NOT NULL,
        end_date DATE NOT NULL,
        status VARCHAR(25) NOT NULL
    );
4. Run the project using Intellij IDEA