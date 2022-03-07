package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.UserDB;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IStorageService;

public class StorageService implements IStorageService {
    private final static StorageService instance = new StorageService();
    private final static UserService service = UserService.getInstance();

    public static StorageService getInstance() {
        return instance;
    }

    @Override
    public User get(String username) {
        for (User user : service.getUserList()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean add(User user) {
        int i = UserDB.insert(user);
        return i != 0;
    }
}
