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

    public static void insertStudent(String id, String firstName, String lastName) throws SQLException {

        String sql = "INSERT INTO students (student_id, first_name, last_name) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.executeUpdate();
        }
    }

    public static void insertMark(String studentId, String courseName, int mark) throws SQLException {

        String sql = "INSERT INTO marks (student_id, course_name, mark) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, studentId);
            stmt.setString(2, courseName);
            stmt.setInt(3, mark);
            stmt.executeUpdate();
        }
    }

    public static java.util.ArrayList<Student> loadAllStudents() {

        java.util.ArrayList<Student> students = new java.util.ArrayList<>();

        String studentSql = "SELECT * FROM students";

        try (Connection conn = connect();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(studentSql)) {

            while (rs.next()) {

                String id = rs.getString("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                Student student = new Student(id, firstName, lastName);

                // now load this student's marks
                loadMarksForStudent(conn, student);

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Failed to load students.");
            e.printStackTrace();
        }

        return students;
    }

    private static void loadMarksForStudent(Connection conn, Student student) throws SQLException {

        String markSql = "SELECT * FROM marks WHERE student_id = ?";

        try (java.sql.PreparedStatement stmt = conn.prepareStatement(markSql)) {

            stmt.setString(1, student.getStudentID());

            try (java.sql.ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String courseName = rs.getString("course_name");
                    int mark = rs.getInt("mark");
                    student.addCourse(new Course(courseName, mark));
                }
            }
        }
    }

    public static void importFromFile() {

        try {

            java.io.File file = new java.io.File("students.txt");
            java.util.Scanner scanner = new java.util.Scanner(file);

            String[] courses = {
                "Mathematics", "Art", "History", "Science",
                "Geography", "Economics", "Literature"
            };

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String firstName = data[1];
                String lastName = data[2];

                insertStudent(id, firstName, lastName);

                for (int i = 0; i < courses.length; i++) {
                    int mark = Integer.parseInt(data[3 + i]);
                    insertMark(id, courses[i], mark);
                }
            }

            scanner.close();
            System.out.println("Import complete!");

        } catch (Exception e) {
            System.out.println("Import failed.");
            e.printStackTrace();
        }
    }

    public static void startWebConsole() throws SQLException {
        org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        System.out.println("H2 web console started. Open this in your browser: http://localhost:8082");
    }

    
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


        try {
            startWebConsole();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
