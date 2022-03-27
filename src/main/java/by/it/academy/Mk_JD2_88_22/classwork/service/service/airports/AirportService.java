package by.it.academy.Mk_JD2_88_22.classwork.service.service.airports;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.airports.IAirportService;
import by.it.academy.Mk_JD2_88_22.classwork.storage.sql.DBAirportStorage;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.IAirportStorage;

import java.util.List;

public class AirportService implements IAirportService {

    private static final AirportService instance = new AirportService();
    private final IAirportStorage storage;

    private AirportService() {
        this.storage = DBAirportStorage.getInstance();
    }

    @Override
    public List<Airport> getList(int page, int size) {
        return this.storage.getList(page, size);
    }

    public static AirportService getInstance() {
        return instance;
    }
}
