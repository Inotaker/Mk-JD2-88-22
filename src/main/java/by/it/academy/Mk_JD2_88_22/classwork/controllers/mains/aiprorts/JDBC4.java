package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains.aiprorts;
import java.sql.*;
import java.util.Scanner;

public class JDBC4 {
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
        String date = console.nextLine();


        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=TestSweetApp", "postgres", "postgres");
             Statement statement = conn.createStatement();
        ) {
            statement.execute(
                    "INSERT INTO app.users (login, password, dt_reg, fio, birthday) " +
                            "VALUES ('"+ login +"', '" + pass +"', now(), '" + name+ "', '" + date + "')");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнение SQL " + e.getMessage());
        }
    }
}
