package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBC3 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=TestSweetApp", "postgres", "postgres");
             PreparedStatement statement = conn.prepareStatement(
                     "INSERT INTO app.users (login, password, dt_reg, fio, birthday) " +
                             "VALUES (?, ?, now(), ?, ?)");
        ) {
            statement.setString(1, "log2");
            statement.setString(2, "111");
            statement.setString(3, "Илья");
            statement.setObject(4, LocalDate.now());
            statement.addBatch();



            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнение SQL " + e.getMessage());
        }
    }
}
