package by.it.academy.Mk_JD2_88_22.classwork.storage.api;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;

import java.util.List;

public interface IAirportStorage {
    List<Airport> getList(int page, int size);
}
