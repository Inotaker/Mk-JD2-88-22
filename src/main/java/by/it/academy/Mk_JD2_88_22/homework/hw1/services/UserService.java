package by.it.academy.Mk_JD2_88_22.homework.hw1.services;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.api.IUserService;
import by.it.academy.Mk_JD2_88_22.classwork.sql.SQLDBAuditUserStorage;

import java.time.LocalDateTime;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();
    private static HibernateStorageUser storage = HibernateStorageUser.getInstance();

    @Override
    public boolean addToStorage(User user) {
        String consumerUsername = user.getUsername();
        if (getWithoutPass(consumerUsername) == null) {
            storage.insert(user);
            SQLDBAuditUserStorage.getInstance().create(new AuditUser(LocalDateTime.now(),"Succsesful registration!", user, user));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getWithoutPass(String username) {
        return storage.selectOne(username);
    }


    public static UserService getInstance() {
        return instance;
    }
}
