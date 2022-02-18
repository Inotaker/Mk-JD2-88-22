package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.servlets.messenger;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", urlPatterns = "/views/signIn")
public class SignInServlet extends HttpServlet {
    UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        for (User user : service.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("usersNotFind", false);
                req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
            } else {
                req.setAttribute("usersNotFind", true);
                req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
    }
}