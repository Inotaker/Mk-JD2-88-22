package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class HibernateInitializer implements AutoCloseable {
    private volatile static HibernateInitializer instance;

    private EntityManagerFactory entityManagerFactory;

    private HibernateInitializer() throws IOException, SQLException, PropertyVetoException {
       entityManagerFactory = Persistence.createEntityManagerFactory
               ("by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.entity");
    }

    public EntityManager getManager() {
        return this.entityManagerFactory.createEntityManager();
    }

    public static HibernateInitializer getInstance() {
        if(instance == null){
            synchronized (HibernateInitializer.class){
                if(instance == null){
                    try{
                        instance = new HibernateInitializer();
                    } catch (Exception e){
                        throw new RuntimeException("Ошибка подключения к базе", e);
                    }
                }
            }
        }
        return instance;
    }

    @Override
    public synchronized void close() throws Exception {
        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }
}