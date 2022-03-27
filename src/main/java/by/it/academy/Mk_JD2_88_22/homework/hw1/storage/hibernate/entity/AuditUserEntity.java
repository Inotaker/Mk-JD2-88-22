package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.entity;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(schema = "messenger", name = "audit_user")
public class AuditUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "author")
    private User author;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "user")
    private User user;

    public AuditUserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AuditUserEntity{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", author=" + author +
                '}';
    }
}
