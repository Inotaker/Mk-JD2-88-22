package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageMessage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.HibernateStorageUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.AuthService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.MessageService;

public class maidsfg {
    private static HibernateStorageUser storage = HibernateStorageUser.getInstance();
private static final AuthService service = AuthService.getInstance();
private static final MessageService messageService = MessageService.getInstance();
private static final HibernateStorageMessage storageMessage= HibernateStorageMessage.getInstance();
    public static void main(String[] args) {
//        storage.insert(new User("Fikus", "1", "Sanya Shima", LocalDate.of(1999,12,12)));
//        service.signUp(new User("VovkaDurak", "1", "Sanya Shima", LocalDate.of(1999,12,12)));
        messageService.sendMessage("Hi", "Inotak", "Vera");
        System.out.println(messageService.getIncomingMessages("Inotak"));
    }
}
