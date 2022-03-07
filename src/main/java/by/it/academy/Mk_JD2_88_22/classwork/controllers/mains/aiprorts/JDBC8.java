package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;
import by.it.academy.Mk_JD2_88_22.classwork.storage.DBAirportStorage;
import by.it.academy.Mk_JD2_88_22.classwork.storage.api.IAirportStorage;

import java.util.List;

public class JDBC8 {
    public static void main(String[] args) {
        IAirportStorage storage = DBAirportStorage.getInstance();

        List<Airport> list = storage.getList(2, 10);

        System.out.println(list);
    }
}
