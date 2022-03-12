package by.it.academy.Mk_JD2_88_22.homework.hw1.dto.audit;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

import java.time.LocalDateTime;

public class AuditUser {
    private Long id;
    private LocalDateTime dtCreate;
    private String text;
    private User user;
    private User author;

    public AuditUser(LocalDateTime dtCreate, String text, User user, User author) {
        this.dtCreate = dtCreate;
        this.text = text;
        this.user = user;
        this.author = author;
    }

    public AuditUser(Long id, LocalDateTime dtCreate, String text, User user, User author) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.text = text;
        this.user = user;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "AuditUser{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", author=" + author +
                '}';
    }
}
