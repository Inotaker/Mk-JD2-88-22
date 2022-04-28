package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/views/logout")
public class LogoutController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest req) {
        req.getSession().invalidate();
        return "main";
    }
}
