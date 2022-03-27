package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.web.servlets;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.AuthService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = "/views/signIn")
public class SignInServlet extends HttpServlet {

    private final AuthService authService = AuthService.getInstance();
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getWithoutPass(username);
        if (user != null) {
            if (authService.signIn(user, password)) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("userLogin", true);
                req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
            } else {
                req.setAttribute("userWrongPassword", true);
                req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("userLogin", false);
            req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userWrongPassword", null);
        req.setAttribute("userLogin", null);
        req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
    }
}