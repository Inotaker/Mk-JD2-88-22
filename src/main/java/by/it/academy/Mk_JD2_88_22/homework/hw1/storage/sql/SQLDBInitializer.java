package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.sql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class SQLDBInitializer {
    private volatile static SQLDBInitializer instance;

    private ComboPooledDataSource cpds;

    private SQLDBInitializer() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5433/users");
        cpds.setUser("postgres");
        cpds.setPassword("postgres");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public DataSource getDataSource() {
        return cpds;
    }

    public static SQLDBInitializer getInstance() {
        if(instance == null){
            synchronized (SQLDBInitializer.class){
                if(instance == null){
                    try{
                        instance = new SQLDBInitializer();
                    } catch (Exception e){
                        throw new RuntimeException("Ошибка подключения к базе", e);
                    }
                }
            }
        }
        return instance;
    }
}