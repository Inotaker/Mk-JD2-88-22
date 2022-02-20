package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();
    private List<User> userList = new ArrayList<>();

    {
        addToStorage(new User("Inotak", "1", "fio", LocalDate.MIN));
        addToStorage(new User("inotak_firman", "1", "fio", LocalDate.MIN));
        addToStorage(new User("Alex", "1", "fio", LocalDate.MIN));
    }

    @Override
    public int getUserCount() {
        return this.userList.size();
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public boolean addToStorage(User user) {
        String consumerUsername = user.getUsername();
        if (getWithoutPass(consumerUsername) == null) {
            this.userList.add(user);
            return true;
        }
        else {
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
