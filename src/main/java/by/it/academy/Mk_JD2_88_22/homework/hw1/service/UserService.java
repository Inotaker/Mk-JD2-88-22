package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.HibernateDBUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IUserService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.sql.SQLDBAuditUserStorage;

import java.time.LocalDateTime;
import java.util.List;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();


    @Override
    public List<User> getUserList() {
        return HibernateDBUserStorage.select();
    }

    @Override
    public boolean addToStorage(User user) {
        String consumerUsername = user.getUsername();
        if (getWithoutPass(consumerUsername) == null) {
            HibernateDBUserStorage.insert(user);
            SQLDBAuditUserStorage.getInstance().create(new AuditUser(LocalDateTime.now(),"Succsesful registration!", user, user));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getWithoutPass(String username) {
        User returningUser = null;
        for (User user1 : getUserList()) {
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
