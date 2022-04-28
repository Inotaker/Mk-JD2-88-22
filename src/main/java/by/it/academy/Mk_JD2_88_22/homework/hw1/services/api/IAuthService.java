package by.it.academy.Mk_JD2_88_22.homework.hw1.services.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;

public interface IAuthService {
    boolean signUp(User user);

    boolean signIn(User user, String password);
}
