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
    }
}
