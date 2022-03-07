package by.it.academy.Mk_JD2_88_22.classwork.storage.api;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Flights;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.FlightsFilter;
import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Pageable;

import java.util.List;

public interface IFlightsStorage {
List<Flights> getList();

        List<Flights> getList(FlightsFilter filter);

        List<Flights> getList(Pageable pageable);

        List<Flights> getList(FlightsFilter filter,
                              Pageable pageable);
}
