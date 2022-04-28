package by.it.academy.Mk_JD2_88_22.homework.hw1.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private long id;
    private String to;
    private String from;
    private String message;
    private LocalDateTime sendingTime;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm:ss");

    public Message(long id, String to, String from, String message, LocalDateTime sendingTime) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.message = message;
        this.sendingTime = sendingTime;
    }

    public Message(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
        sendingTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    @Override
    public String toString() {

        return "Message [" + message + "] from " + from + " to " + to + " in time: " + sendingTime.format(formatter);
    }
}
