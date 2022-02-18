package by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Citizen;

import java.util.List;

public interface ICitizenService {
    List<Citizen> getCitizensList();

    void addCitizen(Citizen citizen);
}
