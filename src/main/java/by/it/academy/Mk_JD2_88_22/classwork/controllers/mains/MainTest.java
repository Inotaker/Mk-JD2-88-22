package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageUser;

public class MainTest {
    private static HibernateStorageUser storage = HibernateStorageUser.getInstance();
    public static void main(String[] args) {
        storage.selectOne("Inotak");
    }
}
