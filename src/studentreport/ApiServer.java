package studentreport;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class ApiServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(7000), 0);

       server.createContext("/students", exchange -> {

            ArrayList<Student> students = Database.loadAllStudents();

            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                json.append("{\"id\":\"").append(s.getStudentID()).append("\",");
                json.append("\"name\":\"").append(s.getFullName()).append("\"}");

                if (i < students.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            String response = json.toString();
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.start();
        System.out.println("API running at http://localhost:7000/hello");
    }
}

