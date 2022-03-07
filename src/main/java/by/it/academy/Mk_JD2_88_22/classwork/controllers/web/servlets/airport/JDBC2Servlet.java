package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.airport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "JDBC2Servlet", urlPatterns = "/jdbc2")
public class JDBC2Servlet extends HttpServlet {
    private static final String url = "jdbc:postgresql://localhost:5433/demo";
    private static final String username = "postgres";
    private static final String password = "postgres";
    private static final String driver = "org.postgresql.Driver";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        DateTimeFormatter dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT departure_airport, arrival_airport, scheduled_arrival FROM demo.bookings.flights;");
                while (resultSet.next()) {
                    String departure_airport = resultSet.getString(1);
                    String arrival_airport = resultSet.getString(2);
                    ZonedDateTime zonedDateTime = ZonedDateTime.parse(resultSet.getString(3),dtf);
                    writer.write(departure_airport + " " + arrival_airport + " " + zonedDateTime + "<br>");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
