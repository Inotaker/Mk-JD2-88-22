package by.it.academy.Mk_JD2_88_22.homework.hw1.service.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.Message;

import java.util.List;

public interface IMessageService {

    List<Message> getAllMessages();

    void sendMessage(String message, String recipient, String sender);

    List<Message> getIncomingMessages(String login);

    List<Message> getOutgoingMessages(String login);

}
