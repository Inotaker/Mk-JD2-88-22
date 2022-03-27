package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains;

import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.HibernateDBUserStorage;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(HibernateDBUserStorage.select());
    }
}
