package by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(schema = "messenger", name = "users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fio")
    private String fio;
    @Column(name = "birth_date")
    private LocalDate birthday;

    public UserEntity() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public UserEntity(String username, String password, String fio, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fio = fio;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
