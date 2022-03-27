package by.it.academy.Mk_JD2_88_22.homework.hw1.service.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

import java.util.List;

public interface IUserService {

    List<User> getUserList();

    boolean addToStorage(User user);

    User getWithoutPass(String username);

}
