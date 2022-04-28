package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.web.controllers;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.MessageService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/views/message")
public class MessageController {
    UserService service = UserService.getInstance();
    MessageService messageService = MessageService.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("messageDeploy", null);
        return "message";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(Model model,
                       @RequestParam(name = "recipient") String recipient,
                       @RequestParam(name = "message") String message,
                       @SessionAttribute(name = "user") User sender) {

        User recipientUser = service.getWithoutPass(recipient);

        if (recipientUser != null) {
            messageService.sendMessage(message, recipient, sender.getUsername());
            model.addAttribute("messageDeploy", true);
        } else {
            model.addAttribute("messageDeploy", false);
        }
        return "message";
    }
}
