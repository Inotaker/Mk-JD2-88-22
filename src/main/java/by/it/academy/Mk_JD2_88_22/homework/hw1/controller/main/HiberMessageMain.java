package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.UserService;

import java.time.LocalDate;

public class HiberMessageMain {
    public static void main(String[] args) {
UserService service = UserService.getInstance();
//        System.out.println(service.getWithoutPass("Inotak"));
        System.out.println(service.addToStorage(new User("Kil", "1", "1", LocalDate.of(1999, 12, 12))));
    }
}
