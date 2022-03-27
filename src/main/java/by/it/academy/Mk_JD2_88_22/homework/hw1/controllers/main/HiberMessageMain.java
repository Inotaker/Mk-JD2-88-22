package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.MessageService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.hibernate.HibernateDBAuditStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.sql.SQLDBAuditUserStorage;

import java.time.LocalDateTime;

public class HiberMessageMain {
    public static void main(String[] args) {
        MessageService service = MessageService.getInstance();
        UserService userService = UserService.getInstance();
        SQLDBAuditUserStorage storage = SQLDBAuditUserStorage.getInstance();
//        service.sendMessage("message","Vika","Inotak");
//        userService.addToStorage(new User("Volodya", "1", "Лабкович Владимир Валерьявич", LocalDate.of(2001,7,12)));
        storage.create(new AuditUser(LocalDateTime.now(),"Succsesful registration", userService.getWithoutPass("Vika"),userService.getWithoutPass("Inotak")));
        System.out.println(HibernateDBAuditStorage.select());
//        System.out.println(service.getIncomingMessages("Vika"));
    }
}
