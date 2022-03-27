package by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class HibernateInitializer {
    private volatile static HibernateInitializer instance;

    private EntityManagerFactory entityManagerFactory;

    private HibernateInitializer() throws IOException, SQLException, PropertyVetoException {
       entityManagerFactory = Persistence.createEntityManagerFactory("by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate");
    }

    public EntityManager getEntityManager() {
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
}