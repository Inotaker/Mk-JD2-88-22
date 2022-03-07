package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.airport;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.AirportName;
import com.google.gson.Gson;

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

@WebServlet(name = "JDBCServlet", urlPatterns = "/jdbc")
public class JDBCServlet extends HttpServlet {
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

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM demo.bookings.airports_data");
                while (resultSet.next()) {
                    String code = resultSet.getString(1);
                    String timezone = resultSet.getString(5);
                    String json_airportName = resultSet.getString(2);

                    AirportName airportName = new Gson().fromJson(json_airportName, AirportName.class);

                    writer.write(timezone + " " + code + " " + airportName + "<br>");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
