package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

public interface IFactoryStorage {
    IUserStorage getStorageUser();

    IMessageStorage getStorageMessage();

    IAuditUserStorage getAuditUserStorage();
}
