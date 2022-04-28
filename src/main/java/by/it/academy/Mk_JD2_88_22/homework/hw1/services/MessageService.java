package by.it.academy.Mk_JD2_88_22.homework.hw1.services;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageMessage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {
    private final static MessageService instance = new MessageService();
private final static HibernateStorageMessage storage = HibernateStorageMessage.getInstance();

    @Override
    public void sendMessage(String message, String recipient, String sender) {
        storage.insert(new Message(recipient, sender, message));
    }

    @Override
    public List<Message> getIncomingMessages(String login) {
        return storage.selectIncomeMessages(login);
    }

    @Override
    public List<Message> getOutgoingMessages(String login) {
        return storage.selectOutcomeMessages(login);
    }

    public static MessageService getInstance() {
        return instance;
    }
}
