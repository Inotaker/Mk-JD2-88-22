package by.it.academy.Mk_JD2_88_22.homework.hw1.dto;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MessageDB {
    private static String url = "jdbc:postgresql://localhost:5433/users";
    private static String username = "postgres";
    private static String password = "postgres";
    private static String driver = "org.postgresql.Driver";


    public static ArrayList<Message> select() {

        ArrayList<Message> messages = new ArrayList<>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users.messenger.message");
                while (resultSet.next()) {
                    String text = resultSet.getString(1);
                    String from = resultSet.getString(2);
                    String to = resultSet.getString(3);
                    LocalDateTime sendTime = resultSet.getTimestamp(4).toLocalDateTime();
                    Message message = new Message(to, from, text);
                    message.setSendingTime(sendTime);
                    messages.add(message);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return messages;
    }


//    public static User selectOne(int id) {
//
//        User user = null;
//        try {
//            Class.forName(driver).getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "SELECT * FROM users WHERE id=?";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setInt(1, id);
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    if (resultSet.next()) {
//
//                        String username = resultSet.getString(1);
//                        String password = resultSet.getString(2);
//                        String fio = resultSet.getString(3);
//                        user = new User(username, password, fio, LocalDate.MAX);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return user;
//    }


    public static int insert(Message message) {

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO users.messenger.message (text, \"from\", \"to\", send_dt) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, message.getMessage());
                    preparedStatement.setString(2, message.getFrom());
                    preparedStatement.setString(3, message.getTo());
                    preparedStatement.setObject(4, message.getSendingTime());

                    return preparedStatement.executeUpdate();
                }
            } catch (PSQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("/*\\Message not added/*\\");
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
