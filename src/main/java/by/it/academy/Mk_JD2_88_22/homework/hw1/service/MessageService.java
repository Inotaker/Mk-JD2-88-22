package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.MessageDB;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IMessageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageService implements IMessageService {
    private final static MessageService instance = new MessageService();

    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = MessageDB.select();
        return messages;
    }


    @Override
    public void sendMessage(String message, String recipient, String sender) {
        MessageDB.insert(new Message(recipient, sender, message));
    }

    @Override
    public List<Message> getIncomingMessages(String login) {
        List<Message> messageList = getAllMessages();
        return messageList.stream().filter(message -> message.getTo().equals(login)).collect(Collectors.toList());
    }

    @Override
    public List<Message> getOutgoingMessages(String login) {
        List<Message> messageList = getAllMessages();
        return messageList.stream().filter(message -> message.getFrom().equals(login)).collect(Collectors.toList());
    }

    public static MessageService getInstance() {
        return instance;
    }
}
