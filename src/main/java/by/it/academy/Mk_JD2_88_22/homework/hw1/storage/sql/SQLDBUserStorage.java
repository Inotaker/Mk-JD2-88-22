package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.sql;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SQLDBUserStorage {
    private static String url = "jdbc:postgresql://localhost:5433/users";
    private static String username = "postgres";
    private static String password = "postgres";
    private static String driver = "org.postgresql.Driver";

    public static ArrayList<User> select() {

        ArrayList<User> users = new ArrayList<>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users.messenger.users");
                while (resultSet.next()) {

                    String username = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    String fio = resultSet.getString(3);
                    LocalDate birthday = LocalDate.parse(resultSet.getString(4));
                    User user = new User(username, password, fio, birthday);
                    users.add(user);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }


    public static User selectOne(String login) {

        User user = null;
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "SELECT * FROM users.messenger.users WHERE username=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, login);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String username = resultSet.getString(1);
                        String password = resultSet.getString(2);
                        String fio = resultSet.getString(3);
                        LocalDate birthdate = LocalDate.parse(resultSet.getString(4));
                        user = new User(username, password, fio, birthdate);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return user;
    }

    public static int insert(User user) {

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO users.messenger.users (username, password, fio, birth_date) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getFio());
                    preparedStatement.setObject(4,user.getBirthday());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println("User not added/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        }
        return 0;
    }


//    public static int update(User user) {
//
//        try {
//            Class.forName(driver).getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "UPDATE users SET name = ?, price = ? WHERE id = ?";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setString(1, user.getUsername());
//                    preparedStatement.setString(2, user.getPassword());
//                    preparedStatement.setString(3, user.getFio());
//
//                    return preparedStatement.executeUpdate();
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return 0;
//    }


//    public static int delete(int id) {
//
//        try {
//            Class.forName(driver).getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "DELETE FROM users WHERE id = ?";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setInt(1, id);
//
//                    return preparedStatement.executeUpdate();
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return 0;
//    }
}

