package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class JDBC5 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        Scanner console = new Scanner(System.in);
        String login = console.nextLine();
        String pass = console.nextLine();
        String name = console.nextLine();


        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=TestSweetApp", "postgres", "postgres");
             PreparedStatement statement = conn.prepareStatement(
                     "INSERT INTO app.users (login, password, dt_reg, fio, birthday) " +
                             "VALUES (?, ?, now(), ?, ?)");
        ) {
            statement.setString(1, login);
            statement.setString(2, pass);
            statement.setString(3, name);
            statement.setObject(4, LocalDate.now());
            statement.addBatch();

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнение SQL " + e.getMessage());
        }
    }
}
