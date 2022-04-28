package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.web.controllers;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.AuthService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/views/signIn")
public class SignInController {

    private final AuthService authService = AuthService.getInstance();
    private final UserService userService = UserService.getInstance();

    @RequestMapping(method = RequestMethod.POST)
    public String post(Model model,
                       @RequestParam(name = "username") String username,
                       @RequestParam(name = "password") String password,
                       HttpServletRequest req) {

        User user = userService.getWithoutPass(username);
        if (user != null) {
            if (authService.signIn(user, password)) {
                req.getSession().setAttribute("user", user);
                model.addAttribute("user", user);
                model.addAttribute("userLogin", true);
                return "signIn";
            } else {
                model.addAttribute("userWrongPassword", true);
                return "signIn";
            }
        } else {
            model.addAttribute("userLogin", false);
            return "signIn";
        }
    }
}