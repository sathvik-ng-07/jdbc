# Java JDBC Example

This Java program demonstrates the usage of JDBC (Java Database Connectivity) to connect to a MySQL database, execute SQL queries, and retrieve and insert data into the `employee` table.

## Prerequisites

Before running the code, make sure you have the following:

- JDK installed on your machine.
- MySQL server installed, and the MySQL JDBC driver (`mysql-connector-java-x.x.xx.jar`) included in your classpath.

## Usage

1. Clone the repository or copy the Java code into a file named `Main.java`.
2. Replace the database connection details, such as `url`, `username`, and `password`, with your MySQL server details.
3. Adjust the SQL queries, parameters, and values based on your specific database and use case.
4. Compile and run the Java program.


javac Main.java
java Main


## Code Structure

- `Main.java`: The main Java class containing the JDBC code.
- `mysql-connector-java-x.x.xx.jar`: The MySQL JDBC driver.

## Description

### JDBC Connection

- The program uses the `DriverManager` class to load the MySQL JDBC driver (`com.mysql.cj.jdbc.Driver`).
- The `DriverManager` establishes a connection to the MySQL database using the provided URL, username, and password.

### Statement and PreparedStatement

- Two types of statements are used: `Statement` and `PreparedStatement`.
- `Statement`: Used for executing SQL queries without parameters.
- `PreparedStatement`: Used for executing parameterized SQL queries. It helps prevent SQL injection and improves performance.

### SELECT Query

- A `PreparedStatement` is used to execute a SELECT query that retrieves data based on the name 'John Doe' from the `employee` table.
- The retrieved data is printed to the console.

### INSERT Queries

- Two types of INSERT queries are demonstrated: one using `Statement` and the other using `PreparedStatement`.
- The `Statement` version inserts a new employee with fixed values into the `employee` table.
- The `PreparedStatement` version inserts another new employee with parameterized values into the `employee` table.

### Exception Handling

- Exception handling is implemented to catch potential errors during database operations. SQLExceptions are caught and printed to the console.



