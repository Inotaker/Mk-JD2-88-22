package by.it.academy.Mk_JD2_88_22.homework.hw1.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String fio;
    private LocalDate birthday;

    private List<Message> incomingMessages = new ArrayList<>();
    private List<Message> outgoingMessages = new ArrayList<>();

    public boolean valid;

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

    public List<Message> getIncomingMessages() {
        return incomingMessages;
    }

    public List<Message> getOutgoingMessages() {
        return outgoingMessages;
    }


    public User(String username, String password, String fio, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fio = fio;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", birthday=" + birthday +
                ", incomingMessages=" + incomingMessages +
                ", outgoingMessages=" + outgoingMessages +
                ", valid=" + valid +
                '}';
    }
}
