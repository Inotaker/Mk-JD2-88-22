package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class HibernateDBInitializer {
    private volatile static HibernateDBInitializer instance;

    private EntityManagerFactory entityManagerFactory;

    private HibernateDBInitializer() throws IOException, SQLException, PropertyVetoException {
       entityManagerFactory = Persistence.createEntityManagerFactory("by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate");
    }

    public EntityManager getEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }

    public static HibernateDBInitializer getInstance() {
        if(instance == null){
            synchronized (HibernateDBInitializer.class){
                if(instance == null){
                    try{
                        instance = new HibernateDBInitializer();
                    } catch (Exception e){
                        throw new RuntimeException("Ошибка подключения к базе", e);
                    }
                }
            }
        }
        return instance;
    }
}