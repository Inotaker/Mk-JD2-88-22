package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.servlets.messenger;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.MessageService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IMessageService;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/views/message")
public class MessageServlet extends HttpServlet {
    UserService service = UserService.getInstance();
    MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messageDeploy", null);
        req.getRequestDispatcher("/views/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String recipient = req.getParameter("recipient");
        User sender = (User) req.getSession().getAttribute("user");
        User recipientUser = service.getWithoutPass(recipient);
        if (recipientUser != null) {
            messageService.sendMessage(message, recipient, sender.getUsername());
            req.setAttribute("messageDeploy", true);
        } else {
            req.setAttribute("messageDeploy", false);
        }
        req.getRequestDispatcher("/views/message.jsp").forward(req, resp);
    }
}
