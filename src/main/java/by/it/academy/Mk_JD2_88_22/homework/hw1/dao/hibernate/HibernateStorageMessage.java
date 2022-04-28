package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IMessageStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateInitializer;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.MessageEntity;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper.MessageMapper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HibernateStorageMessage implements IMessageStorage {

    private static final HibernateStorageMessage instance = new HibernateStorageMessage();
private static final MessageMapper mapper = MessageMapper.getInstance();
    public static HibernateStorageMessage getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Message> selectOutcomeMessages(String login){

        ArrayList<Message> messages = new ArrayList<>();

        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
        Root<MessageEntity> root = query.from(MessageEntity.class);
        query.select(root).where(root.get("from").in(login));

        try {
            List<MessageEntity> resultList = manager.createQuery(query).getResultList();
            for (MessageEntity message : resultList) {
                messages.add(mapper.toDto(message));
            }
            return messages;
        } catch (NoResultException e) {
            return null;
        } finally {
            manager.close();
        }
    }
    @Override
    public ArrayList<Message> selectIncomeMessages(String login){

        ArrayList<Message> messages = new ArrayList<>();

        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
        Root<MessageEntity> root = query.from(MessageEntity.class);
        query.select(root).where(root.get("to").in(login));

        try {
            List<MessageEntity> resultList = manager.createQuery(query).getResultList();
            for (MessageEntity message : resultList) {
                messages.add(mapper.toDto(message));
            }
            return messages;
        } catch (NoResultException e) {
            return null;
        } finally {
            manager.close();
        }
    }
@Override
    public int insert(Message message) {
        EntityManager entityManager = HibernateInitializer.getInstance().getManager();
        entityManager.getTransaction().begin();

//        MessageEntity addedMessage = new MessageEntity();
//
//        addedMessage.setMessage(message.getMessage());
//        addedMessage.setFrom(message.getFrom());
//        addedMessage.setTo(message.getTo());
//        addedMessage.setSendingTime(message.getSendingTime());

        entityManager.persist(mapper.toEntity(message));

        entityManager.getTransaction().commit();
        entityManager.close();
        return 1;
    }
}
