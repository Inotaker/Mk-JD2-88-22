package by.it.academy.Mk_JD2_88_22.homework.hw1.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String recipientLogin;
    private String senderLogin;
    private String message;
    private LocalDateTime sendingTime;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm:ss");

    public String getRecipientLogin() {
        return recipientLogin;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setRecipientLogin(String recipientLogin) {
        this.recipientLogin = recipientLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Message(String recipientLogin, String senderLogin, String message) {
        this.recipientLogin = recipientLogin;
        this.senderLogin = senderLogin;
        this.message = message;
        this.sendingTime = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "Message [" + message + "] from " + senderLogin + " to " + recipientLogin + " in time: " + sendingTime.format(formatter);
    }
}
