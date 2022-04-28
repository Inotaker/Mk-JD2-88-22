package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.web.controllers;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/views/chats")
public class ChatsController {

    private MessageService messageService = MessageService.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String index(@SessionAttribute(name = "user",
            required = false) User user,
                        Model model) {
        List<Message> incomingMessages = messageService.getIncomingMessages(user.getUsername());
        List<Message> outgoingMessages = messageService.getOutgoingMessages(user.getUsername());

        model.addAttribute("outgoingMessages", outgoingMessages);
        model.addAttribute("incomingMessages", incomingMessages);
        return "chats";
    }

}
