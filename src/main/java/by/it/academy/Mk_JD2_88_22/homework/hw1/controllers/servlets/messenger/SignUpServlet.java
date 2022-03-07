package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.servlets.messenger;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.AuthService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", urlPatterns = "/views/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    private AuthService authService = AuthService.getInstance();

    private boolean usernameEmpty = false;
    private boolean passwordEmpty = false;
    private boolean fioEmpty = false;
    private boolean birthdayEmpty = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        if (req.getParameter("username").equals("")) {
            req.setAttribute("usernameEmpty", true);
            usernameEmpty = true;
        }
        String username = req.getParameter("username");

        if (req.getParameter("password").equals("")) {
            req.setAttribute("passwordEmpty", true);
            passwordEmpty = true;
        }
        String password = req.getParameter("password");

        if (req.getParameter("fio").equals("")) {
            req.setAttribute("fioEmpty", true);
            fioEmpty = true;
        }
        String fio = req.getParameter("fio");
        if (req.getParameter("birthday") == null || req.getParameter("birthday").equals("")) {
            req.setAttribute("birthdayEmpty", true);
            birthdayEmpty = true;
        }
        if (usernameEmpty || passwordEmpty || fioEmpty || birthdayEmpty) {
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));

        User user = new User(username, password, fio, birthday);
        if (authService.signUp(user)) {
            req.setAttribute("userCreated", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        } else {
            req.setAttribute("userExists", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }
}
