package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(schema = "messenger", name = "message")

public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "\"to\"")
    private String to;
    @Column(name = "\"from\"")
    private String from;
    @Column(name = "text")
    private String message;
    @Column(name = "send_dt")
    private LocalDateTime sendingTime;

    public MessageEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", message='" + message + '\'' +
                ", sendingTime=" + sendingTime +
                '}';
    }
}
