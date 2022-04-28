package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IAuditUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IFactoryStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IMessageStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageAuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageMessage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageUserWithAuditDecorator;

public class HibernateFactoryDecoratorStorage implements IFactoryStorage {
    @Override
    public IUserStorage getStorageUser() {
        return HibernateStorageUserWithAuditDecorator.getInstance();
    }

    @Override
    public IMessageStorage getStorageMessage() {
        return HibernateStorageMessage.getInstance();
    }

    @Override
    public IAuditUserStorage getAuditUserStorage() {
        return HibernateStorageAuditUser.getInstance();
    }
}
