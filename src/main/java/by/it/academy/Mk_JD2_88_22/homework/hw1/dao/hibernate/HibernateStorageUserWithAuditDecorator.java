package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateInitializer;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import java.time.LocalDateTime;

public class HibernateStorageUserWithAuditDecorator implements IUserStorage {
    private static final HibernateStorageUserWithAuditDecorator instance = new HibernateStorageUserWithAuditDecorator();

    public static HibernateStorageUserWithAuditDecorator getInstance() {
        return instance;
    }

    private final HibernateStorageUser storageUser;
    private final HibernateStorageAuditUser auditUserStorage;

    private HibernateStorageUserWithAuditDecorator() {
        this.storageUser = HibernateStorageUser.getInstance();
        this.auditUserStorage = HibernateStorageAuditUser.getInstance();
    }

    @Override
    public User selectOne(String login) {
        return storageUser.selectOne(login);
    }

    @Override
    public void insert(User user) {
        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        try {
            this.storageUser.add(user, manager);
            AuditUser auditUser = new AuditUser(LocalDateTime.now(), "Регистрация", user, null);
            this.auditUserStorage.insert(auditUser, manager);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new IllegalArgumentException("Ошибка регистрации");
        } finally {
            manager.close();
        }
    }
}