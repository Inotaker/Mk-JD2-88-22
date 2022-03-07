package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=TestSweetApp", "postgres", "postgres");
             Statement statement = conn.createStatement();
        ) {
            statement.execute(
                    "INSERT INTO app.users (login, password, dt_reg, fio, birthday) " +
                            "VALUES ('log1', '111', now(), 'Илья', '2022-01-01')");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнение SQL " + e.getMessage());
        }
    }
}
