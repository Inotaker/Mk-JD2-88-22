package by.it.academy.Mk_JD2_88_22.classwork.service.service.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson.ICitizenService;
import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Citizen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitizenService implements ICitizenService {
    private static final CitizenService instance = new CitizenService();
    private List<Citizen> citizens = new ArrayList<>();

    public List<Citizen> getCitizensList() {
        return Collections.unmodifiableList(citizens);
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    public static CitizenService getInstance() {
        return instance;
    }
}
