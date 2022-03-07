package by.it.academy.Mk_JD2_88_22.homework.hw1.service;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IMessageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageService implements IMessageService {
    private final static MessageService instance = new MessageService();

    private Map<String, List<Message>> messageStorageByLogin = new HashMap<>();
    private static int messagesCount = 0;

    public Map<String, List<Message>> getMessageStorageByLogin() {
        return messageStorageByLogin;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        this.messageStorageByLogin.values().forEach(messages::addAll);
        return messages;
    }


    @Override
    public void sendMessage(String message, String recipient, String sender) {
        List<Message> messages = this.messageStorageByLogin.getOrDefault(sender, new ArrayList<>());
        messages.add(new Message(recipient, sender, message));
        this.messageStorageByLogin.put(sender, messages);
        messagesCount++;
    }

    @Override
    public List<Message> getIncomingMessages(String login) {
        List<Message> incomingMessagesList = getAllMessages();
        return incomingMessagesList.stream().filter(message -> message.getRecipientLogin().equals(login)).collect(Collectors.toList());
    }

    @Override
    public List<Message> getOutgoingMessages(String login) {
        List<Message> outgoingMessagesList = new ArrayList<>();
        messageStorageByLogin.values().forEach(outgoingMessagesList::addAll);
        return outgoingMessagesList.stream().filter(message -> message.getSenderLogin().equals(login)).collect(Collectors.toList());
    }

    @Override
    public int getMessagesCount() {
        return messagesCount;
    }

    public static MessageService getInstance() {
        return instance;
    }
}
