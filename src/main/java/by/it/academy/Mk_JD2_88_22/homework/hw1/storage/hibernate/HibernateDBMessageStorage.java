package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate;

import by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate.HibernateInitializer;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.entity.MessageEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HibernateDBMessageStorage {

    public static ArrayList<Message> select() {

        ArrayList<Message> messages = new ArrayList<>();
        HibernateInitializer hibernateInitializer = HibernateInitializer.getInstance();
        EntityManager manager = hibernateInitializer.getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = builder.createQuery(MessageEntity.class);
        Root<MessageEntity> from = query.from(MessageEntity.class);
        query.select(from);

        List<MessageEntity> resultList = manager.createQuery(query).getResultList();
        for (MessageEntity message : resultList) {
            Message addedMessage = new Message(message.getTo(), message.getFrom(), message.getMessage());
            addedMessage.setSendingTime(message.getSendingTime());
            messages.add(addedMessage);
        }
        return messages;
    }

    public static int insert(Message message) {
        HibernateInitializer hibernateInitializer = HibernateInitializer.getInstance();
        EntityManager entityManager = hibernateInitializer.getEntityManager();
        entityManager.getTransaction().begin();
        MessageEntity addedMessage = new MessageEntity();

        addedMessage.setMessage(message.getMessage());
        addedMessage.setFrom(message.getFrom());
        addedMessage.setTo(message.getTo());
        addedMessage.setSendingTime(LocalDateTime.now());

        entityManager.persist(addedMessage);
        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
//    public static ArrayList<Message> select() {
//
//        ArrayList<Message> messages = new ArrayList<>();
//        try {
//            Class.forName(driver).getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM users.messenger.message");
//                while (resultSet.next()) {
//                    String text = resultSet.getString(1);
//                    String from = resultSet.getString(2);
//                    String to = resultSet.getString(3);
//                    LocalDateTime sendTime = resultSet.getTimestamp(4).toLocalDateTime();
//                    Message message = new Message(to, from, text);
//                    message.setSendingTime(sendTime);
//                    messages.add(message);
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return messages;
//    }


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
