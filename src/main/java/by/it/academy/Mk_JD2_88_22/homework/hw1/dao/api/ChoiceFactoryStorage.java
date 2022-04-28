package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateFactoryDecoratorStorage;

public class ChoiceFactoryStorage implements IFactoryStorage{
    private static final ChoiceFactoryStorage instance = new ChoiceFactoryStorage();

    private IFactoryStorage fs = new HibernateFactoryDecoratorStorage();

    @Override
    public IUserStorage getStorageUser() {
        return fs.getStorageUser();
    }

    @Override
    public IMessageStorage getStorageMessage() {
        return fs.getStorageMessage();
    }

    @Override
    public IAuditUserStorage getAuditUserStorage() {
        return fs.getAuditUserStorage();
    }

    public static ChoiceFactoryStorage getInstance() {
        return instance;
    }
}
