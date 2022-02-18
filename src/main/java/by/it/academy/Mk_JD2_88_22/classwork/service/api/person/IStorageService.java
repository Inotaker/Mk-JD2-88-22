package by.it.academy.Mk_JD2_88_22.classwork.service.api.person;

import by.it.academy.Mk_JD2_88_22.classwork.dto.person.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStorageService {

    void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response);

    Person getFromStorage(HttpServletRequest request, HttpServletResponse response);

}
