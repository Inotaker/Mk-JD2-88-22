package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Message;

import java.util.ArrayList;

public interface IMessageStorage {

     ArrayList<Message> selectOutcomeMessages(String login);

     ArrayList<Message> selectIncomeMessages(String login);

     int insert(Message message);
}
