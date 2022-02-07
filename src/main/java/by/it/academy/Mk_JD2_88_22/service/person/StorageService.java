package by.it.academy.Mk_JD2_88_22.service.person;
import by.it.academy.Mk_JD2_88_22.service.api.dto.person.Person;
import by.it.academy.Mk_JD2_88_22.service.api.person.IStorageService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StorageService implements IStorageService {

    private static final StorageService instance = new StorageService();

    @Override
    public void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public Person getFromStorage(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


    public static StorageService getInstance() {
        return instance;
    }
}
