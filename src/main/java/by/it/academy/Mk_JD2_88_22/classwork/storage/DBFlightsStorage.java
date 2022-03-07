package by.it.academy.Mk_JD2_88_22.classwork.storage;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Flights;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.FlightsFilter;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Pageable;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.DBInitializer;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.IFlightsStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBFlightsStorage implements IFlightsStorage {
    private static DBFlightsStorage instance = new DBFlightsStorage();
    private final ObjectMapper mapper = new ObjectMapper();
    private final DataSource dataSource;

    public DBFlightsStorage() {
        dataSource = DBInitializer.getInstance().getDataSource();
    }

    @Override
    public List<Flights> getList() {
        return getList(null, null);
    }

    @Override
    public List<Flights> getList(FlightsFilter filter) {
        return getList(filter, null);
    }

    @Override
    public List<Flights> getList(Pageable pageable) {
        return getList(null, pageable);
    }

    @Override
    public List<Flights> getList(FlightsFilter filter,
                                 Pageable pageable) {
        Integer limit = null;
        Integer offset = null;

        if(pageable != null){
            if(pageable.getSize() > 0){
                limit = pageable.getSize();
            }

            if(limit != null && pageable.getPage() > 0){
                offset = (pageable.getPage() - 1) * limit;
            }
        }


        List<Flights> flights = new ArrayList<>();

        String sql = "SELECT\n" +
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
                "    bookings.flights";

        List<Object> params = new ArrayList<>();

        if(filter != null){
            String where = "";
            if(filter.getArrivalAirport() != null && !filter.getArrivalAirport().isEmpty()){
                where += "arrival_airport = ?";
                params.add(filter.getArrivalAirport());
            }
            if(filter.getDepartureAirport() != null && !filter.getDepartureAirport().isEmpty()){
                if(!where.isEmpty()){
                    where += " AND ";
                }
                where += "departure_airport = ?";
                params.add(filter.getDepartureAirport());
            }
            if(filter.getScheduledDeparture() != null){
                if(!where.isEmpty()){
                    where += " AND ";
                }
                where += "scheduled_departure = ?";
                params.add(filter.getScheduledDeparture());
            }
            if(!where.isEmpty()){
                sql += "\n WHERE " + where;
            }
        }
        if(limit != null){
            sql += "\n LIMIT " + limit;
        }
        if (offset != null){
            sql += "\n OFFSET " + offset;
        }
        sql += ";";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/demo?ApplicationName=TestSweetApp", "postgres", "postgres");
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            int index = 1;
            for (Object param : params) {
                ps.setObject(index++, param);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    int flightIdDB = rs.getInt(1);
                    String flightNoDB = rs.getString(2);
                    LocalDateTime scheduledDepartureDB = rs.getTimestamp(3).toLocalDateTime();
                    LocalDateTime scheduledArrivalDB = rs.getTimestamp(4).toLocalDateTime();
                    String departureAirportDB = rs.getString(5);
                    String arrivalAirportDB = rs.getString(6);
                    String statusDB = rs.getString(7);
                    String aircraftCodeDB = rs.getString(8);
                    LocalDateTime actualDepartureDB = null;
                    LocalDateTime actualArrivalDB = null;

                    if (rs.getTimestamp(9) != null) {
                        actualDepartureDB = rs.getTimestamp(9).toLocalDateTime();
                    }
                    if (rs.getTimestamp(10) != null) {
                        actualArrivalDB = rs.getTimestamp(10).toLocalDateTime();
                    }

                    Flights flight = new Flights();
                    flight.setFlightId(flightIdDB);
                    flight.setFlightNo(flightNoDB);
                    flight.setScheduledDeparture(scheduledDepartureDB);
                    flight.setScheduledArrival(scheduledArrivalDB);
                    flight.setDepartureAirport(departureAirportDB);
                    flight.setArrivalAirport(arrivalAirportDB);
                    flight.setStatus(statusDB);
                    flight.setAircraftCode(aircraftCodeDB);
                    flight.setActualDeparture(actualDepartureDB);
                    flight.setActualArrival(actualArrivalDB);
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнение SQL", e);
        }
        return flights;
    }

    public static DBFlightsStorage getInstance() {
        return instance;
    }
}
