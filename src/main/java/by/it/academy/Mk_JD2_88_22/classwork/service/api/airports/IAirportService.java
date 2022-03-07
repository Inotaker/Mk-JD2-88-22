package by.it.academy.Mk_JD2_88_22.classwork.service.api.airports;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;

import java.util.List;

public interface IAirportService {
    List<Airport> getList(int page, int size);
}
