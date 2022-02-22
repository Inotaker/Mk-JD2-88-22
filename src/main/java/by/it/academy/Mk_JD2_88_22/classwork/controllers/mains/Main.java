package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/demo?ApplicationName=TestSweetApp", "postgres", "postgres");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT\n" +
                     "    flight_id,\n" +
                     "    flight_no,\n" +
                     "    scheduled_departure,\n" +
                     "    scheduled_arrival,\n" +
                     "    departure_airport,\n" +
                     "    arrival_airport,\n" +
                     "    status,\n" +
                     "    aircraft_code,\n" +
                     "    actual_departure,\n" +
                     "    actual_arrival\n" +
                     "FROM\n" +
                     "    bookings.flights;\n")
        ) {
            int count = 0;
            while (rs.next()){
                System.out.println(rs.getString("aircraft_code"));
                count++;
            }
            System.out.println(count);
        } catch (SQLException e) {
            System.out.println("Ошибка выполнение SQL " + e.getMessage());
        }
    }
}
