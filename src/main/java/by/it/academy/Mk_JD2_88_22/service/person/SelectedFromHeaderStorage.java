package by.it.academy.Mk_JD2_88_22.service.person;

import by.it.academy.Mk_JD2_88_22.service.dto.person.Person;
import by.it.academy.Mk_JD2_88_22.service.api.person.IStorageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectedFromHeaderStorage implements IStorageService {
    private final IStorageService cookiesStorage;
    private final IStorageService sessionStorage;

    public SelectedFromHeaderStorage() {
        this.cookiesStorage = new CookiesStorage();
        this.sessionStorage = new SessionStorage();
    }

    @Override
    public void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response) {
        getService(request).addToStorage(person, request, response);
    }

    @Override
    public Person getFromStorage(HttpServletRequest request, HttpServletResponse response) {
        return getService(request).getFromStorage(request, response);
    }

    private IStorageService getService(HttpServletRequest request){
        String storage = request.getHeader("storage");

        if("SESSION".equalsIgnoreCase(storage)){
            return this.sessionStorage;
        } else if ("COOKIES".equalsIgnoreCase(storage)){
            return this.cookiesStorage;
        } else {
            throw new IllegalArgumentException("Не возможно найти выбранное хранилище");
        }
    }
}
