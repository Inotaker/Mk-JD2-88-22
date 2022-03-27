package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.AuthService;

import java.time.LocalDate;

public class maidsfg {
    public static void main(String[] args) {
        System.out.println(AuthService.getInstance().signUp(new User("Boka", "1", "Андрей Какой то Там", LocalDate.now())));
    }
}
