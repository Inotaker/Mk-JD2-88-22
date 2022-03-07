package by.it.academy.Mk_JD2_88_22.homework.hw1.service.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

public interface IStorageService {
    User get(String username);

    boolean add(User user);
}
