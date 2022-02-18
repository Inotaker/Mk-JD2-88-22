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
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", urlPatterns = "/views/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fio = req.getParameter("fio");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));

        if (username != null && password != null && fio != null && birthday != null) {
            User user = new User(username, password, fio, birthday);
            userService.addToStorage(user);
            writer.write("<p>Hello" + " " + username + " " + password + "<p>");
            writer.write(userService.getFromStorage(username, password).toString());

            if (user.equals(userService.getFromStorage(username, password))) {
                req.removeAttribute("userExists");
                req.setAttribute("userExists", true);
            }
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        } else {
            req.removeAttribute("userExists");
            req.setAttribute("userExists", false);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }
}
