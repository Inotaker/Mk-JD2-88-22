package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;

public interface IUserStorage {

    User selectOne(String login);

    void insert(User user);
}
