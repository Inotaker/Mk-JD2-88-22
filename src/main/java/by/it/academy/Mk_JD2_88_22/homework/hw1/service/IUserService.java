package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

import java.util.List;

public interface IUserService {
    void addToStorage(User user);

    User getFromStorage(String username, String password);

    User getWithoutPass(String username);

}
