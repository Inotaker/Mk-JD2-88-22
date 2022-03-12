package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.service.MessageService;

public class mainDb {
    public static void main(String[] args) {
        MessageService service = MessageService.getInstance();
        System.out.println(service.getAllMessages());
//        service.sendMessage("Hello rabochaya loshadka", "Nikita", "Inotak");
//        System.out.println(service.getOutgoingMessages("Inotak"));
//        System.out.println(service.getIncomingMessages("Inotak"));
    }
}
