package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.UserDB;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IAuthService;

public class AuthService implements IAuthService {
    private static final AuthService instance = new AuthService();

    public static AuthService getInstance() {
        return instance;
    }


    @Override
    public boolean signUp(User user) {
        if (UserDB.insert(user) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean signIn(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
