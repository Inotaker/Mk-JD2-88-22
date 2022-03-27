package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;
import by.it.academy.Mk_JD2_88_22.classwork.storage.sql.DBAirportStorage;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.IAirportStorage;

import java.util.List;

public class JDBC6 {
    public static void main(String[] args) {
        IAirportStorage storage = DBAirportStorage.getInstance();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            List<Airport> list = storage.getList(10, 0);
        }
        long stop = System.currentTimeMillis();

        System.out.println(stop - start);
    }
}
