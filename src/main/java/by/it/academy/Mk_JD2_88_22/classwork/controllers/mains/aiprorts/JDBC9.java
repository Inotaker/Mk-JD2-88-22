package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Flights;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.FlightsFilter;
import by.it.academy.Mk_JD2_88_22.classwork.storage.sql.DBFlightsStorage;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.IFlightsStorage;

import java.util.List;

public class JDBC9 {
    public static void main(String[] args) {
        IFlightsStorage storage = DBFlightsStorage.getInstance();

        FlightsFilter flightsFilter = FlightsFilter.Builder.builder()
                .setArrivalAirport("KUF")
                .build();

        List<Flights> list = storage.getList(flightsFilter);

        System.out.println(list);
    }
}
