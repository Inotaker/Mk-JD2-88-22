//package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.web.servlets;
//
//import by.it.academy.Mk_JD2_88_22.homework.hw1.model.dto.Message;
//import by.it.academy.Mk_JD2_88_22.homework.hw1.model.dto.User;
//import by.it.academy.Mk_JD2_88_22.homework.hw1.view.MessageService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "ChatsServlet", urlPatterns = "/views/chats")
//public class ChatsServlet extends HttpServlet {
//    private MessageService messageService = MessageService.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = (User) req.getSession().getAttribute("user");
//        List<Message> incomingMessages = messageService.getIncomingMessages(user.getUsername());
//        List<Message> outgoingMessages = messageService.getOutgoingMessages(user.getUsername());
//
//        req.setAttribute("outgoingMessages", outgoingMessages);
//        req.setAttribute("incomingMessages", incomingMessages);
//        req.getRequestDispatcher("/views/chats.jsp").forward(req, resp);
//    }
//
//}
