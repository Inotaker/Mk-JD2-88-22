package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.web.controllers;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/views/signUp")
public class SignUpController {
    private AuthService authService = AuthService.getInstance();

    private boolean usernameEmpty = false;
    private boolean passwordEmpty = false;
    private boolean fioEmpty = false;
    private boolean birthdayEmpty = false;

    @RequestMapping(method = RequestMethod.POST)
    public String post(Model model,
                       @RequestParam(name = "birthday") String birthdayParam,
                       @RequestParam(name = "username") String usernameParam,
                       @RequestParam(name = "password") String passwordParam,
                       @RequestParam(name = "fio") String fioParam) {

        if (usernameParam.equals("")) {
            model.addAttribute("usernameEmpty", true);
            usernameEmpty = true;
        }

        if (passwordParam.equals("")) {
            model.addAttribute("passwordEmpty", true);
            passwordEmpty = true;
        }

        if (fioParam.equals("")) {
            model.addAttribute("fioEmpty", true);
            fioEmpty = true;
        }

        if (birthdayParam == null || birthdayParam.equals("")) {
            model.addAttribute("birthdayEmpty", true);
            birthdayEmpty = true;
        }


        if (usernameEmpty || passwordEmpty || fioEmpty || birthdayEmpty) {
            return "signUp";
        }
        LocalDate birthday = LocalDate.parse(birthdayParam);

        User user = new User(usernameParam, passwordParam, fioParam, birthday);
        if (authService.signUp(user)) {
            model.addAttribute("userCreated", true);
            return "signUp";
        } else {
            model.addAttribute("userExists", true);
            return "signUp";
        }
    }
}
