package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.AirportName;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.City;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Coordinates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC7 {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();


        long start = System.currentTimeMillis();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/demo?ApplicationName=TestSweetApp", "postgres", "postgres");) {
            for (int i = 0; i < 100; i++) {
                List<Airport> airports = new ArrayList<>();
                try (
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery("SELECT\n" +
                                "    airport_code,\n" +
                                "    airport_name,\n" +
                                "    city,\n" +
                                "    coordinates,\n" +
                                "    timezone\n" +
                                "FROM\n" +
                                "    bookings.airports_data;")
                ) {
                    while (rs.next()) {
                        Airport airport = new Airport();
                        airport.setAirportCode(rs.getString(1));
                        String airportName = rs.getString(2);
                        if (!rs.wasNull()) {
                            airport.setAirportName(mapper.readValue(airportName, AirportName.class));
                        }

                        String city = rs.getString(3);
                        if (!rs.wasNull()) {
                            airport.setCity(mapper.readValue(city, City.class));
                        }
                        String rawCoordinates = rs.getString(4);
                        if (!rs.wasNull()) {
                            String[] split = rawCoordinates.replaceAll("(\\(|\\))", "").split(",");
                            airport.setCoordinates(new Coordinates(split[0], split[1]));
                        }
                        airport.setTimeZone(rs.getString(5));
                        airports.add(airport);
                    }

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнение SQL", e);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Невозможно преобразовать json из базы", e);
        }
        long stop = System.currentTimeMillis();

        System.out.println(stop - start);
    }
}
