package studentreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // This is the address of our database file (H2 will create it automatically)
    private static final String URL = "jdbc:h2:./studentdb";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {

        String createStudents = 
            "CREATE TABLE IF NOT EXISTS students (" +
            "student_id VARCHAR(10) PRIMARY KEY, " +
            "first_name VARCHAR(50), " +
            "last_name VARCHAR(50))";

        String createMarks = 
            "CREATE TABLE IF NOT EXISTS marks (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "student_id VARCHAR(10), " +
            "course_name VARCHAR(50), " +
            "mark INT)";

        try (Connection conn = connect();
             java.sql.Statement stmt = conn.createStatement()) {

            stmt.execute(createStudents);
            stmt.execute(createMarks);

            System.out.println("Tables created successfully!");

        } catch (SQLException e) {
            System.out.println("Failed to create tables.");
            e.printStackTrace();
        }
    }

    // Just for testing - not part of the real program yet
    public static void main(String[] args) {

        try {
            Connection conn = connect();
            System.out.println("Connected to database successfully!");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
        createTables();
    }
}
