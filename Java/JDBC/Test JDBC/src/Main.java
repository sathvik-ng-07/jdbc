import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Satu56ma?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            try (Connection con = DriverManager.getConnection(url, username, password);
                 Statement st = con.createStatement()) {

                System.out.println("Connection Established");

                // PreparedStatement for SELECT query
                String selectQuery = "SELECT * FROM employee WHERE name = ?";
                try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
                    ps.setString(1, "John Doe");
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String job_title = rs.getString("job_title");
                            double salary = rs.getDouble("salary");

                            System.out.println();
                            System.out.println("=================");
                            System.out.println("ID: " + id);
                            System.out.println("Name: " + name);
                            System.out.println("Job Title: " + job_title);
                            System.out.println("Salary: " + salary);
                        }
                    }
                }

                // Normal Statement for INSERT query
                String normalInsertQuery = "INSERT INTO employee (id, name, job_title, salary) " +
                        "VALUES (11, 'Yet Another Employee', 'Yet Another Job Title', 130000.00)";
                int normalInsertRowsAffected = st.executeUpdate(normalInsertQuery);
                System.out.println("Rows affected by Normal INSERT: " + normalInsertRowsAffected);

                // PreparedStatement for INSERT query
                String preparedInsertQuery = "INSERT INTO employee (id, name, job_title, salary) VALUES (?,?,?,?)";
                try (PreparedStatement preparedInsertPs = con.prepareStatement(preparedInsertQuery)) {
                    preparedInsertPs.setInt(1, 12);
                    preparedInsertPs.setString(2, "One More Employee");
                    preparedInsertPs.setString(3, "One More Job Title");
                    preparedInsertPs.setDouble(4, 140000.00);
                    int preparedInsertRowsAffected = preparedInsertPs.executeUpdate();
                    System.out.println("Rows affected by Prepared INSERT: " + preparedInsertRowsAffected);
                }

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}

