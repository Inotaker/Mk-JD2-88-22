package by.it.academy.Mk_JD2_88_22.homework.hw1.dto;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User implements DAO, Serializable {
    private static final long serialVersionUID = 1l;
    private String username;
    private String password;
    private String fio;
    private LocalDate birthday;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public User(String username, String password, String fio, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fio = fio;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return username + " fio: " + fio + " birthday: " + birthday;
    }

    @Override
    public Object save(Object o) throws SQLException {
        return null;
    }

    @Override
    public Object get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Object o) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    public static class Builder {
        private String login;
        private String password;
        private String fio;
        private LocalDate birthday;
        private LocalDateTime registration;

        private Builder() {

        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setFio(String fio) {
            this.fio = fio;
            return this;
        }

        public Builder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder setRegistration(LocalDateTime registration) {
            this.registration = registration;
            return this;
        }

        public static Builder createBuilder() {
            return new Builder();
        }

        public User build() {
            return new User(login, password, fio, birthday);
        }
    }
}
