package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IAuthService;

public class AuthService implements IAuthService {
    UserService userService = UserService.getInstance();
    private static final AuthService instance = new AuthService();

    public static AuthService getInstance() {
        return instance;
    }


    @Override
    public boolean signUp(User user) {
        return userService.addToStorage(user);
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
