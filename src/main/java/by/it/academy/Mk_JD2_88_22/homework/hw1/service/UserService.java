package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.UserDB;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();
    private List<User> userList = new ArrayList<>();

    @Override
    public int getUserCount() {
        return this.userList.size();
    }

    @Override
    public List<User> getUserList() {
        this.userList = UserDB.select();
        return userList;
    }

    @Override
    public boolean addToStorage(User user) {
        String consumerUsername = user.getUsername();
        if (getWithoutPass(consumerUsername) == null) {
            UserDB.insert(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getFromStorage(String username, String password) {
        User returningUser = null;
        for (User user1 : userList) {
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                returningUser = user1;
            }
        }
        return returningUser;
    }

    @Override
    public User getWithoutPass(String username) {
        User returningUser = null;
        for (User user1 : userList) {
            if (user1.getUsername().equals(username)) {
                returningUser = user1;
            }
        }
        return returningUser;
    }


    public static UserService getInstance() {
        return instance;
    }
}
