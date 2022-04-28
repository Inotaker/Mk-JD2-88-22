package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;

import java.sql.*;
import java.time.LocalDateTime;

public class mainDb {
    private static String url = "jdbc:postgresql://localhost:5433/users";
    private static String username = "postgres";
    private static String password = "postgres";
    private static String driver = "org.postgresql.Driver";

    public static void main(String[] args) {
        AuditUser auditUser = new AuditUser(LocalDateTime.now(),
                "Регистрация",
                User.Builder.createBuilder().setLogin("Inotak").build(),
                User.Builder.createBuilder().setLogin("Nikita").build()
        );
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO messenger.audit_user (text, author, dt_create, \"user\") VALUES (?,?,?,?);\n";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setObject(1, auditUser.getText());
                    preparedStatement.setObject(2, auditUser.getAuthor() != null ? auditUser.getAuthor().getUsername() : null);
                    preparedStatement.setObject(3, auditUser.getDtCreate());
                    preparedStatement.setObject(4, auditUser.getUser().getUsername());

                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                        } else {
                            throw new SQLException("Creating user failed, no ID obtained.");
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("User not added/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        }
    }
}
