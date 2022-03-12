package by.it.academy.Mk_JD2_88_22.homework.hw1.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String to;
    private String from;
    private String message;
    private LocalDateTime sendingTime;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm:ss");

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Message(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.sendingTime = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "Message [" + message + "] from " + from + " to " + to + " in time: " + sendingTime.format(formatter);
    }
}
